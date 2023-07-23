package com.aiokleo.streamApi;

import jdk.jfr.DataAmount;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String newJoiner;
    private int salary;
    private int rating;
}
