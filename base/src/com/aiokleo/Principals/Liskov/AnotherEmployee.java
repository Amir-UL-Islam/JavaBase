package com.aiokleo.Principals.Liskov;

import com.aiokleo.Principals.OpenClose.Employee;
import com.aiokleo.Principals.OpenClose.PermanentEmployee;

public class AnotherEmployee {

    public static void main(String[] args) {

        // Base Type
        Employee employee = new Employee(1L, "John");

        // Derived Type must be completely substitutable for its base type
        PermanentEmployee permanentEmployee = new PermanentEmployee(1L, "John", true);

        AnotherEmployee anotherEmployee = new AnotherEmployee();

        // And must have all the properties of its base type
        anotherEmployee.printEmployee(permanentEmployee);
    }

    void printEmployee(Employee employee) {
        System.out.println(employee.getName());
    }
}
