package com.aiokleo.problemSolving.recursion.selfsimilarity;

/**
 * The first key characteristic is self-similarity, also often referred to as repetition. In the context of the recursive algorithm, the self-similarity property implies that an algorithm is applied to a problem only if the problem can be broken down into smaller instances of the same problem itself
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Solution.fibonacci(6));
    }
    /**
     * fundamental property of a recursive algorithm is the recursion rule,
     * more often known as the recursive case.
     * This rule essentially defines how the function should make progress towards the base case.
     * <p>
     * Here is the Recursion Rule for the Fibonacci sequence:
     * fibinacci(n) = fibinacci(n-1) + fibinacci(n-2)
     * <p>
     * a well-defined recursive rule is crucial for ensuring that recursive algorithms function as intended
     * It's the driving force that propels it forward,
     * enabling the function to make steady progress towards the base case,
     * without which the recursion might either not cease or deviate from its purpose.
     * <p>
     * definition:
     * The Recursion Rule, in the context of recursive algorithms,
     * is a command or an operational instruction
     * that determines how the recursive function should progress towards its base case,
     * by defining the utilization of results of smaller instances of the problem.
     */
    static class Solution {
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return (fibonacci(n - 1) + fibonacci(n - 2));
            }
        }
    }
}
