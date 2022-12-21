package com.aiokleo.optionals;
class Dog{
    public Dog(int age,
               String nameOfTheDog) {
        this.age = age;
        this.nameOfTheDog = nameOfTheDog;
    }
    private int age;

    public int getAge() {
        return age;
    }

    public String getNameOfTheDog() {
        return nameOfTheDog;
    }

    private String nameOfTheDog;



}

public class Optionals {
    // Optional is a Container.
    // Optional EITHER Contain Something or NOT.
    // Lest Say we Have a simple method in our program THAT Took the name of a cat as parameter
    // Then went to the DATABASE and RETReIVEd a cat Object with That name and Returned it.

    public static void main(String[] args) {
        Dog myDog = findDogByName("doggy");
        System.out.println(myDog.getAge());
        // What if There are Not Dog Named "doggy".
        // goto line findDogByName method section to READ REST

    }
    private static Dog findDogByName (String nameOfTheDog){
        // In real Application This method would Fetch a Dog From DATABASE
        // For NOw
        Dog dog = new Dog(2, nameOfTheDog);
        // the method findDogByName() should return a NULL.
        return dog;
//        return null; // But this line will arise a Exception.
//        we can deal this position with NULL CHECK.
    }
}
