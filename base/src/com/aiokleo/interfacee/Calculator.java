package com.aiokleo.interfacee;

import java.text.NumberFormat;
import java.util.Scanner;

// default public, static and final

//Like abstract classes, interfaces cannot be used to create objects

//Interface methods are by default abstract and public
// 1. An abstract method has [No Body]. (It has no statements.)
// 2. It declares an access modifier, return type, and method signature followed by a semicolon.



//Why And When To Use Interfaces?
//1) To achieve security - hide certain details and only show the important details of an object (interface).

//2) Java does not support "multiple inheritance" (a class can only inherit from one superclass).
// However, it can be achieved with interfaces,
// because the class can implement multiple interfaces.
// Note: To implement multiple interfaces, separate them with a comma (see example below).


interface Calculate {
    void input();
    void output();

}

class Calculator implements Calculate {
    int principal;
    float interest;
    float monthlyInterest;
    int year;
    int numberOfPayments;
    double mortgage;
    String result;

    // All input and Calculation
    @Override
    public void input() {

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner= new Scanner(System.in);
        System.out.print("Principal: ");
        principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        interest = scanner.nextFloat();
        monthlyInterest = interest / MONTH_IN_YEAR / PERCENT;

        System.out.print("Number of Year: ");
        year = scanner.nextInt();
        numberOfPayments =  year * MONTH_IN_YEAR;

        mortgage = principal * (monthlyInterest * (Math.pow((1 + monthlyInterest), numberOfPayments))) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);

        // Number Formatter
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        result = currency.format(mortgage);
    }

    @Override
    public void output() {
        // Printing Result
        System.out.print(result + "\n");

    }

    public static void main(String[] args){
        Calculator c = new Calculator();
        c.input();
        c.output();

    }
}
