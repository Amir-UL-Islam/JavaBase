package com.aiokleo.FizzBuzz;

import java.util.Scanner;

public class FizzBuzz03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int Number = scan.nextInt();

        if (Number % 5 == 0){
            if (Number % 3 == 0){
                System.out.print("FizzBuzz");
            }else
                System.out.print("Fizz");
        }
        else if (Number % 3 == 0) {
            System.out.print("Buzz");
        }
        else
            System.out.print(Number);
    }
}
