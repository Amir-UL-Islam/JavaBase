package com.aiokleo.graph.connectedcomponent;

import java.lang.reflect.Method;
import java.util.*;

public class IsConnectedComponentCount {
    public static void main(String[] args) {

        Set<Integer> visited = new HashSet<>();
        List<Object> visitedList = new ArrayList<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> graph02 = new HashMap<>();

        // Adding nodes and their adjacency lists
        graph.put(3, Collections.emptyList());
        graph.put(4, Collections.singletonList(6));
        graph.put(6, Arrays.asList(4, 5, 7, 8));
        graph.put(8, Collections.singletonList(6));
        graph.put(7, Collections.singletonList(6));
        graph.put(5, Collections.singletonList(6));
        graph.put(1, Collections.singletonList(2));
        graph.put(2, Collections.singletonList(1));

        graph02.put(0, Arrays.asList(8, 1, 5));
        graph02.put(1, Collections.singletonList(0));
        graph02.put(5, Arrays.asList(0, 8));
        graph02.put(8, Arrays.asList(0, 5));
        graph02.put(2, Arrays.asList(3, 4));
        graph02.put(3, Arrays.asList(2, 4));
        graph02.put(4, Arrays.asList(3, 2));

        printGraph(graph02);
        System.out.println(IsConnectedComponentCount.connectedComponent(graph02, visited, visitedList));


    }

    public static void printGraph(Map<Integer, List<Integer>> graph) {

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            System.out.print(node + ": ");
            for (Integer neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static <T> Integer connectedComponent(Map<T, List<T>> graph, Set<T> visited, List<Object> visitedList) {

        var count = 0;
        var largestIsland = 0;
        // 1. Recursive
        for (T neighbor : graph.keySet()) {
            if (explore(graph, neighbor, visited, visitedList, largestIsland)) {
                count++;
            }
        }
//
//        // 2. DFS(Need to be fixed)
//        for (T neighbor : graph.keySet()) {
//            if (explore(graph, neighbor, visited)) {
//                count++;
//            }
//        }
//
        return count;
    }

    private static <T> boolean explore(Map<T, List<T>> graph, T neighbor, Set<T> visited, List<Object> visitedList, int largestIsland) {
        if (visited.contains(neighbor)) {
            visitedList.add(neighbor + "*");
            return false;
        }
        visited.add(neighbor);
        visitedList.add(neighbor);
//        System.out.println("visited = " + visited);
        System.out.println("visitedList = " + visitedList);

        for (T next : graph.get(neighbor)) {
            explore(graph, next, visited, visitedList, largestIsland);
        }
        return true;
    }

    private static <T> boolean explore(Map<T, List<T>> graph, T neighbor, Set<T> visited) {
        Stack<T> stack = new Stack<>();
        stack.add(neighbor);
        while (!stack.empty()) {
            T current = stack.pop();
            if (visited.contains(current)) continue; // Not going to add the same node twice
            visited.add(current);
            stack.addAll(graph.get(current));
        }
        return true;
    }


}
