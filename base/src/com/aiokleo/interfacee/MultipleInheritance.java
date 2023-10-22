package com.aiokleo.interfacee;

interface FirstInterface {
    void myMethod(); // interface method
}

interface SecondInterface {
   void myOtherMethod(); // interface method
}

class DemoClass implements FirstInterface, SecondInterface { // Multiple Inheritance
    @Override
    public void myMethod() {
        System.out.println("Some text.. Inherit FROM Interface ONE");
    }
    @Override
    public void myOtherMethod() {
        System.out.println("Some other text... Inherit FROM Interface TWO");
    }
}

class Main {
    public static void main(String[] args) {
        DemoClass myObj = new DemoClass();
        myObj.myMethod();
        myObj.myOtherMethod();
        System.out.println("By Inheriting Methods FROM MULTIPLE INTERFACE WE CAN IMPLEMENT multiple inheritance");
    }
}
