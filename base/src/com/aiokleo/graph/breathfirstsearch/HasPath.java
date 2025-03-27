package com.aiokleo.graph.breathfirstsearch;


import com.aiokleo.graph.Graphs;

import java.util.*;

public class HasPath {

    // Recursive
    public static <T> Boolean hasPathRecursive(Map<T, List<T>> graph, T src, T dest, Set<T> visited) {
        System.out.println("Source :" + src + " " + "Destination: " + dest);
        if (visited.contains(src)) return false;// it is visited before there no reason to visit it again
        visited.add(src);
        if (src == dest) return true; // I also can print the path here
//        graph.put('f', Arrays.asList('g', 'i'));
//        graph.put('g', Collections.singletonList('h'));
//        graph.put('i', Arrays.asList('g', 'k'));
//        graph.put('h', Collections.emptyList());
//        graph.put('j', Collections.singletonList('i'));
//        graph.put('k', Collections.emptyList());

        for (T neighbor : graph.get(src)) {
            if (hasPathRecursive(graph, neighbor, dest, visited)) {
                System.out.println("Source :" + src + " " + "Destination: " + dest);
                return true;
            }
        }
        return false;
    }

    // Depth First Search
    public static <T> Boolean hasPathDFS(Map<T, List<T>> graph, T src, T dest) {
        System.out.println("Source :" + src + " " + "Destination: " + dest);
        if (src == dest) return true;
        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();
        stack.add(src);
        while (!stack.empty()) {
            T current = stack.pop();
            if (current == dest) return true; // I also can print the path here, Also if you Never return true, you must return false at the end
            if (visited.contains(current)) continue; // Not going to add the same node twice
            visited.add(current);
            stack.addAll(graph.get(current));
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
        System.out.println(hasPathDFS(graph, 'f', 'h'));
        Set<Character> visited = new HashSet<>();
        System.out.println(hasPathRecursive(graph, 'f', 'k', visited));

    }
}


