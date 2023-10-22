package com.aiokleo.graph.breathfirstsearch;

import com.aiokleo.graph.Graphs;

import java.util.*;

public class HasPath {
    public static Boolean hasPath(Map<Character, List<Character>> graph, Character src, Character dest) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            Character current = queue.poll();
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


// Java program to check if there is exist a path between two vertices
// of a graph.
// This class represents a directed graph using adjacency list
// representation
class Graph {
    private final int V; // No. of vertices
    private final LinkedList<Integer>[] adj; //Adjacency List

    //Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //prints BFS traversal from a given source s
    Boolean isReachable(int s, int d) {
        LinkedList<Integer> temp;

        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            int n;
            i = adj[s].listIterator();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext()) {
                n = i.next();

                // If this adjacent node is the destination node,
                // then return true
                if (n == d)
                    return true;

                // Else, continue to do BFS
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        // If BFS is complete without visited d
        return false;
    }

    // Driver method
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);
        ;

        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);
        ;
    }
}
