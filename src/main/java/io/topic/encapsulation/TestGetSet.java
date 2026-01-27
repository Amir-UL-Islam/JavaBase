package io.topic.encapsulation;

import io.topic.encapsulation.GetterSetter;

public class TestGetSet {

    public static void main(String[] ages){
        GetterSetter person = new GetterSetter();

        person.setName("Amir");
        System.out.println(person.getName());

        person.setAge(22);
        System.out.println(person.getAge());
    }
}
