package com.aiokleo.hashtable;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightChessboard {

    static class Cell {
        int row, col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int solution(int src, int dest) {
        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
//        moveOffsets = [(-1,-2),(-1,2),(-2,-1),(-2,1),
//        ( 1,-2),( 1,2),( 2,-1),( 2,1)]
        int n = 8; // Chessboard size

        // Convert source and destination square numbers to (row, column) coordinates.
        int srcRow = src / n; // 19 / 8 = 2
        int srcCol = src % n; // 19 % 8 = 3
//                -------------------------
//                | 1| 2| 3| 4| 5| 6| 7| 8| -> Colunms
//                -------------------------

//                -------------------------
//                | 0| 1| 2| 3| 4| 5| 6| 7| 1
//                -------------------------
//                | 8| 9|10|11|12|13|14|15| 2
//                -------------------------
//                |16|17|18|19|20|21|22|23| 3
//                -------------------------
//                |24|25|26|27|28|29|30|31| 4
//                -------------------------
//                |32|33|34|35|36|37|38|39| 5
//                -------------------------
//                |40|41|42|43|44|45|46|47| 6
//                -------------------------
//                |48|49|50|51|52|53|54|55| 7
//                -------------------------
//                |56|57|58|59|60|61|62|63| 8 -> Rows
//                -------------------------
//
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]
//        [-1, -1, -1, -1, -1, -1, -1, -1]


        int destRow = dest / n;
        int destCol = dest % n;

        // Create a chessboard represented as a 2D array to store the minimum moves.
        int[][] chessboard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = -1;
            }
        }
        System.out.println(Arrays.deepToString(chessboard));

        // Initialize the source square to 0 moves.
        chessboard[srcRow][srcCol] = 0;

        // Perform a breadth-first search to calculate the minimum moves.
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(srcRow, srcCol));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // Check if the destination square is reached.
            if (current.row == destRow && current.col == destCol) {
                return chessboard[destRow][destCol];
            }

            for (int i = 0; i < 8; i++) {
                int newRow = current.row + dr[i];
                int newCol = current.col + dc[i];

                // Check if the new position is within the chessboard and not visited yet.
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && chessboard[newRow][newCol] == -1) {
                    chessboard[newRow][newCol] = chessboard[current.row][current.col] + 1;
                    queue.add(new Cell(newRow, newCol));
                }
            }
        }

        // If the destination square is not reachable, return -1.
        return -1;
    }

    public static void main(String[] args) {
        int srcSquare = 0;  // Example source square (row 2, column 3)
        int destSquare = 1; // Example destination square (row 4, column 3)
        int result = solution(srcSquare, destSquare);
        System.out.println("Minimum moves from " + srcSquare + " to " + destSquare + ": " + result);
    }
}
