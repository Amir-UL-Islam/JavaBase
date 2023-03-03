package com.aiokleo.interface_inheritance_kotlin
interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "His full name is $firstName $lastName"
}

class Employee(
    // implementing 'name' is not required
    override val firstName: String,
    override val lastName: String,
) : Person{
    override val name: String get() = "His Name is $firstName $lastName"
}
fun main() {
    val employee = Employee("Alice", "Smith" )
    println(employee.name)
}
