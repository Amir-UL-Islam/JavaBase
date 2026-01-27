package com.aiokleo.dryPrinciple;

public class Animal {
    public void eatFood() {
        System.out.println("Eat Food");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eatFood();
        Dog dog = new Dog();
        dog.eatFood();
        dog.woof();
        Cat cat = new Cat();
        cat.eatFood();
        cat.meow();
    }
}

class Dog extends Animal {
    public void woof() {
        System.out.println("Dog Woof! ");
    }
}
class Cat extends Animal {
    public void meow() {
        System.out.println("Cat Meow!");
    }
}
//Violations of the DRY principles are referred to as WET solutions. WET is an abbreviation for the following things:

//Write everything twice
//We enjoy typing
//Write every time
//Waste everyone's twice.
