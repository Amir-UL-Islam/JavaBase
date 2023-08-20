package com.aiokleo.streamApi;

import jdk.jfr.DataAmount;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Employee {
    private String id;
    private String gender;
    private int salary;
}
