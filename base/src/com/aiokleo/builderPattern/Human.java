package com.aiokleo.builderPattern;

import lombok.Data;

import java.util.Date;

@Data
public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private String height;
    private String weight;
    private String eyesColor;
    private String hairColor;
    private String birthPlace;
    private Date birthDate;
    private int numberOfSibling;
    private boolean married;
}
