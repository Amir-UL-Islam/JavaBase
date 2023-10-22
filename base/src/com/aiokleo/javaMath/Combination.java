package com.aiokleo.javaMath;

public class Combination {
    // create the factorial function
    public static int factorial(int num) {
        int result = 1, counter;
        // create for loop
        for (counter = 1; counter <= num; counter++) {
            result = result * counter;
        }

        return result;
    }

    public static void main(String args[]) {
        // create some numbers of objects we want to get the combination
        int n1 = 10;
        int n2 = 4;

        // create number of the objects are taken at a time
        int r1 = 3;
        int r2 = 2;

        // get the combination based on the mathematical formula
        System.out.println(factorial(n1) / (factorial(r1) * factorial(n1 - r1)));
        System.out.println(factorial(n2) / (factorial(r2) * factorial(n2 - r2)));
    }
}
