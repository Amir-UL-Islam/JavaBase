package com.aiokleo.Inheritance;

import java.util.*;

public class Inheritance01 {
    public void main(String[] args) {
        Sing bird = new Sing();
        bird.walk();
        bird.fly();
    }
}
class Animal{
    void walk(){
        System.out.println("I am walking");
    }
}
class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }
}
class Sing extends Bird{
    void sing(){
        System.out.println("I am singing");
    }
}
