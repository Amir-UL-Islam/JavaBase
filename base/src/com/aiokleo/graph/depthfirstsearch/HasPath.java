package com.aiokleo.graph.depthfirstsearch;

import com.aiokleo.graph.Graphs;

import java.util.*;

public class HasPath {
    // Depth First Search Approach
    public static Boolean hasPath(Map<Character, List<Character>> graph, Character src, Character dest) {
        if (src == dest) return true;

        for (Character neighbor : graph.get(src)) {
            if (hasPath(graph, neighbor, dest)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('f', Arrays.asList('g', 'i'));
        graph.put('g', Collections.singletonList('h'));
        graph.put('i', Arrays.asList('g', 'k'));
        graph.put('h', Collections.emptyList());
        graph.put('j', Collections.singletonList('i'));
        graph.put('k', Collections.emptyList());

        Graphs.printGraph(graph);
        System.out.println(hasPath(graph, 'f', 'j'));

    }
}
