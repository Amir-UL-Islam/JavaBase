package com.aiokleo.polymorphism;
//Interpreter vs Compiler
// Interpreter
//In computer science, an interpreter is a computer program that
// directly executes the instructions, which are written in the scripting or programming language.
// Humans can understand only the high-level language,
// which is called source code. Whereas, computers only understand the binary language.
// Hence, the interpreter is required to convert the high-level language into an intermediate language
// And then it executes the source code.

//Compiler
//A compiler is a special program that
// translates a programming language's source code into machine code, bytecode or another programming language.
// The source code is typically written in a high-level, human-readable language such as Java or C++.


// Overriding Vs Overloading

//Overriding
//Implements “runtime polymorphism”
// Runtime Means When USER Using the Program LIKE: Inserting Values or Something


//Overloading
//Implements “compile time polymorphism”
//Compile Time is the Time When The Compiler TRANSLATE language's source code into machine code

public class OverridingVsOverloading {
//    A static class is created inside a class, is called a static nested class in Java.
//    It cannot access non-static data members and methods.
//    - It can access static data members of the outer class, including private.
//    - The static nested class cannot access non-static (instance) data members

    static class Animals{
        public void eat(){
            System.out.println("Animal Eats Here in Supper Class");
        }
    }

    static class Dog extends Animals{ // Creating Polymorphism
        public void eat(){ // Method Overriding
            System.out.println("Dogs Eats Here in Sub Class");
        }
    }

    public static void main(String[] args){
        Animals animal = new Animals();
        animal.eat();

        Dog dog = new Dog();
        dog.eat();


    }
}
