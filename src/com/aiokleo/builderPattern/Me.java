package com.aiokleo.builderPattern;

public class Me {

    public static void main(String[] args) {

        Human amir = new Human.HumanBuilder()
                .withName("Amir")
                .withAge(23)
                .withBirthPlace("Dhaka, Mohammadpur")
                .isMarried(false)
                .withNumberOfSibling(2)
                .build();

        System.out.println(amir.toString());
    }
}
