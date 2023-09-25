package com.aiokleo.Principals.OpenClose;

public class OpenClosed {
    public static void main(String[] args) {
        PermanentEmployee permanentEmployee = new PermanentEmployee(1L, "John", true);
        System.out.println(permanentEmployee.getName() + " " + permanentEmployee.getIsPermanent());
        Employee employee = new Employee(2L, "Jane");
        System.out.println(employee.getName());
    }
}
