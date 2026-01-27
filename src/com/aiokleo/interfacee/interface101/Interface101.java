package com.aiokleo.interfacee.interface101;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        MyCalculator my_calculator = new MyCalculator();
        System.out.println("I implemented: " + my_calculator.getClass().getInterfaces()[0].getName());
        System.out.println(my_calculator.divisor_sum(n));
    }
}
class MyCalculator implements AdvancedArithmetic{
    ArrayList<Integer> divisors = new ArrayList<Integer>();
    @Override
    public int divisor_sum(int n){
        for (int i = 1; i <= n; i ++){
            if (n % i == 0){
                divisors.add(i);
            }
        }
        return divisors.stream().mapToInt(Integer::intValue).sum();
    }
}
