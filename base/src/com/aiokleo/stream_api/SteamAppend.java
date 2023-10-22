package com.aiokleo.stream_api;

import java.util.List;

public class SteamAppend {

    public static void main(String[] args) {
        List<String> vowels = List.of("a", "e", "i", "o", "u");
        System.out.println(vowels.toString());

// sequential stream - nothing to combine
        StringBuilder result = vowels.stream().collect(StringBuilder::new, (x, y) -> x.append(y), (a, b) -> a.append(",").append(b));
        System.out.println(result.toString());

// parallel stream - combiner is combining partial results
        StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y), (a, b) -> a.append(",").append(b));
        System.out.println(result1.toString());
    }
}
