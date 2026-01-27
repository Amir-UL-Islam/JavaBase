//package com.aiokleo.recursion;

/**
 * The first key characteristic is self-similarity, also often referred to as
 * repetition. In the context of the recursive algorithm, the self-similarity
 * property implies that an algorithm is applied to a problem only if the
 * problem can be broken down into smaller instances of the same problem itself
 */


/** In recursion terminology, the case in which our function will not recurse is known as the base case. **/
public class Factorial {
    public static void main(String[] args) {
        // System.out.println(Solution.countDown(5));
        Solution.countDownNonRecursiveII(5);
    }

    /**
     * The base case in this example is when n equals 1,
     * where the function directly returns 1 without proceeding to another recursive
     * call.
     * 
     * A correct and well-defined base case is crucial to prevent infinite recursion
     * in your code,
     * allowing the recursive function to produce the desired result and terminate
     * successfully.
     * <p>
     * The Base Case is an essential stop signal in recursion,
     * a condition or scenario where the function can provide
     * a result in a straightforward manner without needing to invoke another
     * recursion
     */
    static class Solution {
        public static int factorial(int n) {
            if (n == 1) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        }

        public static int countDown(int n) {
            System.out.println(n);
            if (n == 0) {
                return 0;
            } else {
                return countDown(n - 1);
            }
        }

        public static void countDownNonRecursive(int n) {
            while (n >= 0) {
                System.out.println(n);
                n--;
            }
        }

        public static void countDownNonRecursiveII(int n) {
            for (int i = n; i >= 0; i--) {
                System.out.println(i);
            }
        }
    }

}
