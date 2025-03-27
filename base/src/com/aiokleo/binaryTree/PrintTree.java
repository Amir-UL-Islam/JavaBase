package com.aiokleo.binaryTree;

import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int data) {
        this.value = data;
        left = right = null;
    }
}

public class PrintTree {

    static class Tree {
        Node root;

        Tree() {
            root = null;
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int getCol(int h) {
        if (h == 1)
            return 1;
        return getCol(h - 1) + getCol(h - 1) + 1;
    }

    public static void printTree(int[][] M, Node root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.value;
        printTree(M, root.left, col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    public static void TreePrinter(Tree tree) {
        int h = height(tree.root);
        int col = getCol(h);
        int[][] M = new int[h][col];
        printTree(M, tree.root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print(" ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        TreePrinter(tree);
    }
}
