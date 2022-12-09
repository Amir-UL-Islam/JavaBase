package com.aiokleo.encapsulation;

import com.aiokleo.encapsulation.GetterSetter;

public class TestGetSet {

    public static void main(String[] ages){
        GetterSetter person = new GetterSetter();

        person.setName("Amir");
        System.out.println(person.getName());

        person.setAge(22);
        System.out.println(person.getAge());
    }
}
