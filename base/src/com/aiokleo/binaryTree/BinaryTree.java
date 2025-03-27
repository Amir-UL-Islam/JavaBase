package com.aiokleo.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
//package com.aiokleo.binary_tree;
// Binary Tree in Java
// Mostly 2 children per Node
// Exactly 1 Root
// Exactly 1 Path from Any Node to Root
import java.util.stream.Collector;

class BinaryTree {
    static class Node {
        char key;
        Node left, right;

        public Node(char value) {
            key = value;
            left = right = null;
        }
    }

    static Node root;

    BinaryTree(char key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    // Traverse In-order
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }

    // Traverse Post-order
    public static void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.key);
        }
    }

    // Traverse Pre-order
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.key);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public static List<Character> depthFirstSearch(Node root) {
        if (root == null)
            return Collections.emptyList();

        List<Character> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node topCurrent = (Node) stack.pop();
            result.add(topCurrent.key);

            if (topCurrent.left != null)
                stack.push(topCurrent.left);
            if (topCurrent.right != null)
                stack.push(topCurrent.right);
        }
        return result;
    }

    public static List<Character> breathFirstSearch(Node root) {
        if (root == null)
            return Collections.emptyList();

        List<Character> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node topCurrent = (Node) queue.poll();
            result.add(topCurrent.key);

            if (topCurrent.left != null)
                queue.add(topCurrent.left);
            if (topCurrent.right != null)
                queue.add(topCurrent.right);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree('A');

        root.left = new Node('b');
        root.left.left = new Node('d');
        root.right = new Node('c');
        root.right.right = new Node('e');

        // System.out.print("Pre order Traversal: ");
        // tree.traversePreOrder(tree.root);
        // System.out.print("\nIn order Traversal: ");
        // tree.traverseInOrder(tree.root);
        // System.out.print("\nPost order Traversal: ");
        // tree.traversePostOrder(tree.root);
        //
        //
        //
        traversePostOrder(root);
        //System.out.println(depthFirstSearch(root));
        //System.out.println(breathFirstSearch(root));

    }

}
