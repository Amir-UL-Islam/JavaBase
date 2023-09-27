package com.aiokleo.graph.depthfirstsearch;

import java.util.*;

public class DepthFirst {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();

        // Adding nodes and their adjacency lists
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Collections.singletonList('d'));
        graph.put('c', Collections.singletonList('e'));
        graph.put('d', Collections.emptyList());
        graph.put('e', Collections.singletonList('b'));
        graph.put('f', Collections.singletonList('d'));

        // Printing the graph
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            char node = entry.getKey();
            List<Character> neighbors = entry.getValue();

            System.out.print(node + ": ");
            for (Character neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        DepthFirstSearch dfs = new DepthFirstSearch();
        Character source = 'a';
        Stack<Character> result = dfs.dfs(graph, source);
        System.out.println("result = " + result);
    }

    static class DepthFirstSearch {
        public Stack<Character> dfs(Map<Character, List<Character>> graph, Character source) {
            Stack<Character> stack = new Stack<>();
            // Push the source node into stack
            stack.push(source);
            System.out.println("stack = " + stack);

            while (!stack.empty()) {
                // Empty the stack
                Character current = stack.pop();
                System.out.println("current = " + current);
                for (Character neighbor : graph.get(current)) {
                    stack.push(neighbor);
                }
            }
            return stack;
        }

    }
}
