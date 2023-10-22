package com.aiokleo.FizzBuzz;

import java.util.Scanner;

public class FizzBuzz01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int Number = scan.nextInt();

        if (Number % 5 == 0) {
            System.out.print("Fizz");
        }
        else if (Number % 3 == 0) {
            System.out.print("Buzz");
        } else if (Number % 5 == 0 && Number % 3 == 0) {
            System.out.print("FizzBuzz");
        }
        else
            System.out.print(Number);
    }
}
