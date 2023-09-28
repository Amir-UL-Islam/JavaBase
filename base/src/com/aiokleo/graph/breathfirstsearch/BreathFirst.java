package com.aiokleo.graph.breathfirstsearch;
// Java program to find minimum steps to reach to
// specific cell in minimum moves by Knight

import com.aiokleo.graph.Graphs;

import java.util.*;

public class BreathFirst {

    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        BreathFirst.BreathFirstSearch bfs = new BreathFirst.BreathFirstSearch();
        Character source = 'a';
        Queue<Character> result = bfs.bfs(graphs.DemoGraph(), source);
        System.out.println("result = " + result);
    }

    static class BreathFirstSearch {
        public Queue<Character> bfs(Map<Character, List<Character>> graph, Character source) {
            Queue<Character> queue = new LinkedList<Character>();
            // Push the source node into stack
            queue.add(source);
            System.out.println("queue = " + queue);

            while (queue.size() > 0) {
                // Clearing the stack
                Character current = queue.poll();
                System.out.println("current = " + current);
                queue.addAll(graph.get(current));
            }
            return queue;
        }

    }
}