package com.aiokleo.problemSolving.perfectNumber;

import java.util.*;

public class PerfectNumber {
    public static void main(String[] args) {
        int from = 1;
        int to = 100;
        List<Integer> perfectNumbers = getPerfectNumber(from, to);
        System.out.println("These are the perfect number " + perfectNumbers.toString() + " between "
                + String.valueOf(from) + " and " + String.valueOf(to));
    }

    public static List<Integer> getPerfectNumber(int from, int to) {
        List<Integer> perfectNumbers = new ArrayList<>();
        for (int j = from; j <= to; j++) {
            int maybePerfect = 0;
            for (int i = 1; i < j; i++) {
                if (((i % j) == 0) && (i != 1 || i != j)) {
                    maybePerfect += i;
                }
            }
            if ((maybePerfect + 1 + j) == from) {
                perfectNumbers.add(maybePerfect);
            }
        }
        return perfectNumbers;
    }
}
