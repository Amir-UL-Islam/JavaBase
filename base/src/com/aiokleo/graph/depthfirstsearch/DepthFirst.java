package com.aiokleo.graph.depthfirstsearch;

import com.aiokleo.graph.Graphs;

import java.util.*;

public class DepthFirst {

    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        DepthFirstSearch dfs = new DepthFirstSearch();
        Character source = 'a';
        Stack<Character> result = dfs.dfs(graphs.demoGraph(), source);
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
