package com.aiokLeo.demoboot.subPackage;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    public Employee() {
        System.out.println( "\n" + "Employees are Rolling");
    }
}
