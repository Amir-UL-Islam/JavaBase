package com.aiokleo.graph.undirectedpath;

import com.aiokleo.graph.adjacencyconversion.ListToMatrix;
import com.aiokleo.graph.breathfirstsearch.HasPath;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UndirectedPath {
    public static void main(String[] args) {
        char[][] matrix = new char[5][2];
        matrix[0][0] = 'i';
        matrix[0][1] = 'j';
        matrix[1][0] = 'k';
        matrix[1][1] = 'i';
        matrix[2][0] = 'm';
        matrix[2][1] = 'k';
        matrix[3][0] = 'k';
        matrix[3][1] = 'l';
        matrix[4][0] = 'o';
        matrix[4][1] = 'n';

        Map<Character, List<Character>> adjacencyList = ListToMatrix.toAdjacencyList(matrix);
        System.out.println(adjacencyList);

        // For recursive call Please add visited set
        Set<Character> visited = new HashSet<>();
        System.out.println(HasPath.hasPathRecursive(adjacencyList, 'i', 'n', visited));
    }

}
