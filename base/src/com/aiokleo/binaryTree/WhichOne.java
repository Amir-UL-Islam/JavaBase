package com.aiokleo.binaryTree;

public class WhichOne {
    // Trees are non-linear data structures.
    // They are often used to represent hierarchical data
    // A node contains data of any type,
    // but all the nodes must be of the same data type.
    //
    // Root: The root of a tree is a node that has no incoming link
    // Children: The child of a tree is a node with one incoming link from a node
    // above it
    // Parent: The parent node has an outgoing link connecting it to one or more
    // child nodes.
    //
    // Leaf: A leaf has a parent node but has no outgoing link to a child node.
    // Think of this as an endpoint of your tree.
    //
    //
    // Subtree: A subtree is a smaller tree held within a larger tree. The root of
    // that tree can be any node from the bigger tree.
    //
    //
    // Depth: The depth of a node is the number of edges between that node and the
    // root. Think of this as how many steps there are between your node and the
    // tree’s starting point.
    //
    // Height: The height of a node is the number of edges in the longest path from
    // a node to a leaf node. Think of this as how many steps there are between your
    // node and the tree’s endpoint. The height of a tree is the height of its root
    // node.
    //
    // Degree: The degree of a node refers to the number of sub-trees.
    //
    //
    // Also Have only one unique path to root node.
    //

    public static String solution() {
        class Node { // another class or type
            final int key;
            final Node left;
            final Node right;

            Node(int value) {
                this.key = value;
                left = null;
                right = null;
            }
        }
        return null;
    }
}
