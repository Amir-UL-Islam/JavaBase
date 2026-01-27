package io.topic.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            this(value, null, null);
        }

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // Insert a value into the BST
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRec(node.right, value);
        }

        return node;
    }

    // Search for a value in the BST
    public boolean contains(T value) {
        return containsRec(root, value);
    }

    private boolean containsRec(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.equals(node.value)) {
            return true;
        }

        return value.compareTo(node.value) < 0
                ? containsRec(node.left, value)
                : containsRec(node.right, value);
    }

    // Delete a value from the BST
    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private TreeNode<T> deleteRec(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = deleteRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteRec(node.right, value);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get inorder successor
            node.value = minValue(node.right);
            node.right = deleteRec(node.right, node.value);
        }

        return node;
    }

    private T minValue(TreeNode<T> node) {
        T min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }

    // In-order traversal
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }

    // Pre-order traversal
    public void preOrderTraversal() {
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    // Post-order traversal
    public void postOrderTraversal() {
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode<T> node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Get the height of the tree
    public int height() {
        return heightRec(root);
    }

    private int heightRec(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst  = new  BinarySearchTree<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        bst.insert(10);
        bst.insert(11);
        bst.insert(12);
        bst.insert(13);
        bst.insert(14);
        bst.insert(15);
        bst.insert(16);
        bst.insert(17);
        bst.insert(18);
        bst.insert(19);
        bst.insert(20);
        bst.insert(21);
        bst.insert(22);
        bst.insert(23);
        bst.insert(24);
        bst.insert(25);
        bst.insert(26);
        bst.insert(27);
        bst.insert(28);

        bst.insert(29);
        bst.insert(30);


        System.out.println(bst.contains(57));
    }
}
