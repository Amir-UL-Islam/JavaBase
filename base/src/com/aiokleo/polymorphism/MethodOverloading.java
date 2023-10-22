package com.aiokleo.polymorphism;

public class MethodOverloading {
//    static int plusMethodInt(int x, int y) {
//    return x + y;
//}
//
//static double plusMethodDouble(double x, double y) {
//  return x + y;
//}


//    Method Overloading
    static int plusMethod(int x, int y) {
    return x + y;
    }

    static double plusMethod(double x, double y) {
    return x + y;
    }

    public static void main(String[] args){
//        With method overloading, multiple methods can have the same name with different parameters

//        int Num1 = plusMethodInt(8, 5);
//        double Num2 = plusMethodDouble(4.3, 6.26);


        int Num1 = plusMethod(8, 5 );
        double Num2 = plusMethod(4.3, 6.26);


        System.out.println("int: " + Num1);
        System.out.println("double: " + Num2);
    }
}
