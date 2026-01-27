package io.topic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RootedTree<T> {
    private static class TreeNode<T> {
        T data;
        TreeNode<T> parent;
        List<TreeNode<T>> children;

        public TreeNode(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeNode<T> child) {
            child.parent = this;
            this.children.add(child);
        }
    }

    private TreeNode<T> root;

    public RootedTree(T rootData) {
        this.root = new TreeNode<>(rootData);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void addChild(TreeNode<T> parent, T childData) {
        TreeNode<T> child = new TreeNode<>(childData);
        parent.addChild(child);
    }

    // Depth-First Search (Pre-order traversal)
    public void dfsTraversal(TreeNode<T> node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        for (TreeNode<T> child : node.children) {
            dfsTraversal(child);
        }
    }

    // Breadth-First Search (Level-order traversal)
    public void bfsTraversal() {
        if (root == null)
            return;

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.data + " ");
            queue.addAll(current.children);
        }
    }

    // Find a node with given data (DFS)
    public TreeNode<T> findNode(T data) {
        return findNode(root, data);
    }

    private TreeNode<T> findNode(TreeNode<T> node, T data) {
        if (node == null)
            return null;
        if (node.data.equals(data))
            return node;

        for (TreeNode<T> child : node.children) {
            TreeNode<T> found = findNode(child, data);
            if (found != null)
                return found;
        }

        return null;
    }

    // Calculate the depth/height of the tree
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode<T> node) {
        if (node == null)
            return 0;

        int maxHeight = 0;
        for (TreeNode<T> child : node.children) {
            int childHeight = calculateHeight(child);
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }

        return maxHeight + 1;
    }

    public static void main(String[] args) {
        // Example usage
        RootedTree<String> companyStructure = new RootedTree<>("CEO");

        TreeNode<String> root = companyStructure.getRoot();
        companyStructure.addChild(root, "VP Engineering");
        companyStructure.addChild(root, "VP Marketing");

        TreeNode<String> vpEng = companyStructure.findNode("VP Engineering");
        companyStructure.addChild(vpEng, "Manager Backend");
        companyStructure.addChild(vpEng, "Manager Frontend");

        System.out.println("DFS Traversal:");
        companyStructure.dfsTraversal(root);

        System.out.println("\nBFS Traversal:");
        companyStructure.bfsTraversal();

        System.out.println("\nTree Height: " + companyStructure.getHeight());
    }
}
