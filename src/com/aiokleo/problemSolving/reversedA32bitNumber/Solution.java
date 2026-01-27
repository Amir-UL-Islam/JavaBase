package com.aiokleo.problemSolving.reversedA32bitNumber;

public class Solution {
    public static void main(String[] args) {
        ReverseA32bitNumber reverseA32bitNumber = new ReverseA32bitNumber();
        System.out.println(reverseA32bitNumber.reverse(1299888893));
    }
}

class ReverseA32bitNumber {
//    public int reverse(int x) {
//        if (x == 0) return 0;
//        int reversed = 0;
//        while (x != 0) {
//            int reminder = x % 10;
//            reversed = reversed * 10 + reminder;
//            x = x / 10;
//        }
//        if ((reversed < Math.pow(2, 31)) && (reversed > -(Math.pow(2, 31)))) {
//            return reversed;
//        } else {
//            return 0;
//        }
//    }
    public int reverse(int x) {
        int number = Math.abs(x); // Get the absolute value of x
        int reversed = 0;

        while (number > 0) {
            int reminder = number % 10;

            // Check for integer overflow before updating the Reversed Numver
            if (reversed > (Integer.MAX_VALUE - reminder) / 10) {
                return 0;
            }

            // This Position will prevent from skipping the initial Value
            reversed = reversed * 10 + reminder;
            number = number / 10;

        }

        // Restore the sign of the result based on the original number x
        return x < 0 ? -reversed : reversed;

    }
}
