package com.aiokleo.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Defining the Interface
interface PerformOperation {
    boolean check(int a);

}

class MathOperations {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // check given number is prime or not
    public static boolean isPrime(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0)
                return false;
        return true;
    }

    // public static PerformOperation is_prime(){
    // return (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
    // }

    // Checking for isOdd
    public static PerformOperation isOdd() {
        return (int a) -> (a % 2 != 0);
    }

    // Checking for isPrime
    public static PerformOperation isPrime() {
        return (int a) -> isPrime(a);
    }

    public static PerformOperation isPalindrome() {
        return (int n) -> {
            String st = String.valueOf(n);
            StringBuilder sb = new StringBuilder(String.valueOf(n));
            return st.equals(sb.reverse().toString());
        };
    }

}

public class Lambda {
    public static void main(String[] args) throws IOException {
        MathOperations ob = new MathOperations();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        // Takeing the Inputs
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
