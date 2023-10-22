package com.aiokleo.Inheritance;

public class Inheritance02 {
    public static void main(String[] args) {
    Arithmetic ari = new Arithmetic();
    System.out.println("My superclass is: "+ari.getClass().getName());
    System.out.println(ari.sum(40,2)+ " " +ari.sum(10,3)+ " " +ari.sum(10,10));
    }
}

class Adder {
    int sum(int a, int b){
        return a + b;
    }
}
class Arithmetic extends Adder{

}
