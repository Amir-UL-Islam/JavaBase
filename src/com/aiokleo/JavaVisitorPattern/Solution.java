//package com.aiokleo.JavaVisitorPattern;
//
//import com.sun.source.tree.Tree;
//
//import javax.swing.tree.TreeNode;
//import java.util.*;
//
//// Sum of the values in the tree’s leaves only.
//class SumInLeavesVisitor extends TreeVis {
//    private int result = 0;
//
//    public int getResult() {
//        return result;
//    }
//
//    public void visitNode(TreeNode node) {
//        // do nothing
//    }
//
//// Sum of the values in the tree’s leaves only.
//    public void visitLeaf(TreeLeaf leaf) {
//        result += leaf.getValue();
//    }
//}
//
//// Product of values stored in all red nodes, including leaves, computed modulo.
//class ProductOfRedNodesVisitor extends TreeVis {
//    // Note that the product of zero values is equal to One .
//    private long result = 1;
//    private final int M = 1000000007;
//
//    public int getResult() {
//        return (int) result;
//    }
//
//    public void visitNode(TreeNode node) {
//        if (node.getColor() == Color.RED) {
//            result = (result * node.getValue()) % M;
//        }
//    }
//
//    public void visitLeaf(TreeLeaf leaf) {
//        if (leaf.getColor() == Color.RED) {
//            result = (result * leaf.getValue()) % M;
//        }
//    }
//}
//
//// Absolute difference between
//// 1. the sum of values stored in the tree’s non-leaf nodes at even depth
//// 2. And the sum of values stored in the tree’s green leaf nodes.
//class FancyVisitor extends TreeVis {
//    private int nonLeafEvenDepthSum = 0;
//    private int greenLeavesSum = 0;
//
//    public int getResult() {
//        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
//    }
//
//// 1. the sum of values stored in the tree’s non-leaf nodes at even depth
//    public void visitNode(TreeNode node) {
//        if (node.getDepth() % 2 == 0) {
//            nonLeafEvenDepthSum += node.getValue();
//        }
//    }
//
//// 2. And the sum of values stored in the tree’s green leaf nodes.
//    public void visitLeaf(TreeLeaf leaf) {
//        if (leaf.getColor() == Color.GREEN) {
//            greenLeavesSum += leaf.getValue();
//        }
//    }
//}
//
//enum Color {
//    RED,
//    GREEN
//}
//
//// Implement the logic responsible for visiting the tree’s non-leaf nodes such that the getResult method returns the correct  for the implementing class’ visitor.
//class NodeInfo {
//    int index;
//    int value;
//    Color color;
//    Set<Integer> edges;
//
//    public NodeInfo(int index, int value) {
//        this.index = index;
//        this.value = value;
//        this.edges = new HashSet<>();
//    }
//}
//public class Solution {
//
//    private static List<NodeInfo> nodeInfoList;
//
//    public static Tree solve() {
//        Scanner scan = new Scanner(System.in);
//        int numNodes = scan.nextInt();
//
//        nodeInfoList = new ArrayList<>();
//        for (int i = 0; i < numNodes; i++) {
//            nodeInfoList.add(new NodeInfo(i, scan.nextInt()));
//        }
//        for (int i = 0; i < numNodes; i++) {
//            nodeInfoList.get(i).color = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
//        }
//
//        for (int i = 0; i < numNodes - 1; i++) {
//            int u = scan.nextInt() - 1;
//            int v = scan.nextInt() - 1;
//            Set<Integer> uNeighbors = nodeInfoList.get(u).edges;
//            uNeighbors.add(v);
//            Set<Integer> vNeighbors = nodeInfoList.get(v).edges;
//            vNeighbors.add(u);
//        }
//        scan.close();
//
//        NodeInfo rootInfo = nodeInfoList.get(0);
//        if (numNodes == 1) {
//            return new TreeLeaf(rootInfo.value, rootInfo.color, 0);
//        }
//
//        TreeNode root = new TreeNode(rootInfo.value, rootInfo.color, 0);
//        addChildren(root, rootInfo);
//        return root;
//    }
//
//    /* Recursively adds children of a TreeNode */
//    private static void addChildren(TreeNode parent, NodeInfo parentInfo) {
//        for (Integer childNum : parentInfo.edges) {
//            NodeInfo childNodeInfo = nodeInfoList.get(childNum);
//            childNodeInfo.edges.remove(parentInfo.index);
//            Tree tree;
//            if (!childNodeInfo.edges.isEmpty()) {
//                tree = new TreeNode(childNodeInfo.value, childNodeInfo.color, parent.getDepth() + 1);
//            } else {
//                tree = new TreeLeaf(childNodeInfo.value, childNodeInfo.color, parent.getDepth() + 1);
//            }
//            parent.addChild(tree);
//            if (tree instanceof TreeNode) {
//                addChildren((TreeNode) tree, childNodeInfo);
//            }
//        }
//    }
//}
