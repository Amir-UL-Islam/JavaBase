package com.aiokleo.graph.breathfirstsearch;

import com.aiokleo.graph.Graphs;

import java.util.*;

public class HasPath {
    public static <T> Boolean hasPath(Map<T, List<T>> graph, T src, T dest) {
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            T current = queue.poll();
            if (current == dest) return true;
            if (visited.contains(current)) continue; // Not going to add the same node twice
            visited.add(current);
            queue.addAll(graph.get(current));
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


