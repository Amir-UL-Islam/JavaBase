package com.aiokleo.graph.CourseScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        toAdjacencyList(prerequisites);
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {0, 2}};
//        System.out.println(new Solution().canFinish(2, prerequisites));
        System.out.println(toAdjacencyList(prerequisites));
    }

    public static Map<Integer, List<Integer>> toAdjacencyList(int[][] matrix) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Initialize the adjacency list
        for (int[] row : matrix) {
            for (int c : row) {
                adjacencyList.put(c, new ArrayList<>());
            }
        }

        // Populate the adjacency list based on the matrix
        for (int[] chars : matrix) {
            int sourceNode = chars[0];
            int targetNode = chars[1];

            adjacencyList.get(sourceNode).add(targetNode);
            adjacencyList.get(targetNode).add(sourceNode); // if the graph is undirected
        }

        return adjacencyList;
    }

}
