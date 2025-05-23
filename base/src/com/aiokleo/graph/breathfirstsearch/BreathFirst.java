package com.aiokleo.graph.breathfirstsearch;
// Java program to find minimum steps to reach to
// specific cell in minimum moves by Knight

import com.aiokleo.graph.Graphs;

import java.util.*;

public class BreathFirst {

    public static void main(String[] args) {

        Map<Character, List<Character>> graph = new HashMap<>();

        // Adding nodes and their adjacency lists
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Collections.singletonList('d'));
        graph.put('c', Collections.singletonList('e'));
        graph.put('d', Collections.emptyList());
        graph.put('e', Collections.singletonList('b'));
        graph.put('f', Collections.singletonList('d'));

        BreathFirst.BreathFirstSearch bfs = new BreathFirst.BreathFirstSearch();
        Graphs.printGraph(graph);
        Character source = 'a';
        Queue<Character> result = bfs.bfs(graph, source);
        System.out.println("result = " + result);
    }

    static class BreathFirstSearch {
        public Queue<Character> bfs(Map<Character, List<Character>> graph, Character source) {
            Queue<Character> queue = new LinkedList<Character>();
            // Push the source node into stack
            queue.add(source);
            System.out.println("queue = " + queue);

            while (!queue.isEmpty()) {
                // Clearing the stack
                Character current = queue.poll();
                System.out.println("current = " + current);
                queue.addAll(graph.get(current));
            }
            return queue;
        }

    }
}