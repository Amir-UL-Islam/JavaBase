package com.aiokleo

fun main() {
    for (i in 0..10) {
        if (i == 4) {
            continue
            // This portion of code will not be executed
            if (i == 8) break
        }
        println(i)
    }
}
