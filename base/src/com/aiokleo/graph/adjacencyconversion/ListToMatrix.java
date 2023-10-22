package com.aiokleo.graph.adjacencyconversion;

import java.util.*;

public class ListToMatrix {
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

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(toAdjacencyList(matrix));


    }

    //For Undirected Graph
    public static Map<Character, ArrayList<Character>> toAdjacencyList(char[][] matrix) {

        Map<Character, ArrayList<Character>> adjacencyList = new HashMap<>();

        for (char[] listOfCharacter : matrix) {
            for (char character : listOfCharacter) {
                adjacencyList.put(character, new ArrayList<Character>());
            }
            for (char character : listOfCharacter) {

                ArrayList<Character> edge = new ArrayList<Character>(listOfCharacter.length);
                for (char c : listOfCharacter) {
                    for (char j : listOfCharacter) {
                        if (j != c) {
                            edge.add(j);
                        }
                    }
                }
                adjacencyList.put(character, edge);
            }
        }
        return adjacencyList;
    }
}
