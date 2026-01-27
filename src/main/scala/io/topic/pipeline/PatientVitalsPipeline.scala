package io.topic.pipeline

import java.time.{Instant, ZoneOffset}
import java.time.format.DateTimeFormatter

object PatientVitalsPipeline {
  final case class RawVitals(patientId: String, hr: Int, spo2: Int, ts: Long)

  final case class FhirObservation(
                                    patientId: String,
                                    loincCode: String,
                                    value: String,
                                    unit: String,
                                    issuedUtc: String
                                  )

  final case class Alert(patientId: String, reason: String, ts: Long)

  private val LoincHeartRate = "8867-4"
  private val LoincSpO2 = "59408-5"
  private val TachycardiaThreshold = 120
  private val HypoxiaThreshold = 90
  private val MaxLatenessSeconds = 2 * 60 * 60
  private val UtcFormatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC)

  def main(args: Array[String]): Unit = {
    val sampleJson = Seq(
      """{ "patient_id": "P123", "hr": 145, "spo2": 92, "ts": 1674849600 }""",
      """{ "patient_id": "P999", "hr": 72, "spo2": 98, "ts": 1674849660 }""",
      """{ "patient_id": "P777", "hr": 88, "spo2": 86, "ts": 1674846000 }"""
    )

    val nowTs = 1674853200L // Simulated "current" time for late-arrival checks

    val rawEvents = sampleJson.flatMap(parseVitals)
    val (onTime, lateBeyondAllowed) = rawEvents.partition(v => isWithinLateness(nowTs, v.ts))

    println("== On-time or acceptably late events ==")
    onTime.foreach { v =>
      val observations = toFhirObservations(v)
      val alerts = detectAlerts(v)
      observations.foreach(o => println(s"FHIR Observation: $o"))
      alerts.foreach(a => println(s"ALERT: $a"))
    }

    println("\n== Dropped (too late) events ==")
    lateBeyondAllowed.foreach(v => println(s"DROPPED: $v"))
  }

  def parseVitals(json: String): Option[RawVitals] = {
    val patientId = extractString(json, "patient_id")
    val hr = extractInt(json, "hr")
    val spo2 = extractInt(json, "spo2")
    val ts = extractLong(json, "ts")
    for {
      pid <- patientId
      h <- hr
      s <- spo2
      t <- ts
    } yield RawVitals(pid, h, s, t)
  }

  def toFhirObservations(v: RawVitals): Seq[FhirObservation] = {
    val issued = UtcFormatter.format(Instant.ofEpochSecond(v.ts))
    Seq(
      FhirObservation(maskPatientId(v.patientId), LoincHeartRate, v.hr.toString, "bpm", issued),
      FhirObservation(maskPatientId(v.patientId), LoincSpO2, v.spo2.toString, "%", issued)
    )
  }

  def detectAlerts(v: RawVitals): Seq[Alert] = {
    val alerts = scala.collection.mutable.ListBuffer.empty[Alert]
    if (v.hr > TachycardiaThreshold) {
      alerts += Alert(v.patientId, s"Tachycardia hr=${v.hr}", v.ts)
    }
    if (v.spo2 < HypoxiaThreshold) {
      alerts += Alert(v.patientId, s"Hypoxia spo2=${v.spo2}", v.ts)
    }
    alerts.toList
  }

  def isWithinLateness(nowTs: Long, eventTs: Long): Boolean = {
    (nowTs - eventTs) <= MaxLatenessSeconds
  }

  private def maskPatientId(id: String): String = {
    if (id.length <= 2) "P**" else s"${id.take(1)}***${id.takeRight(1)}"
  }

  private def extractString(json: String, key: String): Option[String] = {
    val pattern = (""""""" + key + """":\s*"([^"]+)"""").r
    pattern.findFirstMatchIn(json).map(_.group(1))
  }

  private def extractInt(json: String, key: String): Option[Int] = {
    extractLong(json, key).map(_.toInt)
  }

  private def extractLong(json: String, key: String): Option[Long] = {
    val pattern = (""""""" + key + """":\s*([0-9]+)""").r
    pattern.findFirstMatchIn(json).map(_.group(1).toLong)
  }
}
