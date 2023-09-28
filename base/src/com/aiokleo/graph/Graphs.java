package com.aiokleo.graph;

import java.util.*;

public class Graphs {
    public Map<Character, List<Character>> DemoGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();

        // Adding nodes and their adjacency lists
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Collections.singletonList('d'));
        graph.put('c', Collections.singletonList('e'));
        graph.put('d', Collections.emptyList());
        graph.put('e', Collections.singletonList('b'));
        graph.put('f', Collections.singletonList('d'));

        // Printing the graph
        for (
                Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            char node = entry.getKey();
            List<Character> neighbors = entry.getValue();

            System.out.print(node + ": ");
            for (Character neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        return graph;
    }

}
