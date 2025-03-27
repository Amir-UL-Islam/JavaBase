package com.aiokleo.problemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */


public class BobAliceScore {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = BobAliceScore.compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        Integer[] score = new Integer[2];

        for (int i = 0; i < a.size() - 1; i++){
            if(a.get(i) == b.get(i)){
                continue;
            } else if( a.get(i) > b.get(i)){
                score[0] += 1;
            } else {
                score[1] += 1;
            }
        }
        return Arrays.asList(score);
    }

    public static List<Integer> compareTripletsV1(List<Integer> a, List<Integer> b) {
        // Initialize scores for Alice and Bob
        int aliceScore = 0;
        int bobScore = 0;

        // Ensure both lists are the same size
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Input lists must be of the same size");
        }

        // Compare elements of both lists
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }

        // Return the result as a list
        return Arrays.asList(aliceScore, bobScore);
    }


}
