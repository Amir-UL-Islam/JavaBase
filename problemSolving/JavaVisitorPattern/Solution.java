class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

class NodeInfo {
    int index;
    int value;
    Color color;
    Set<Integer> edges;

    public NodeInfo(int index, int value) {
        this.index = index;
        this.value = value;
        this.edges = new HashSet<>();
    }
}

public class Solution {

    private static List<NodeInfo> nodeInfoList;

    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int numNodes = scan.nextInt();

        nodeInfoList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            nodeInfoList.add(new NodeInfo(i, scan.nextInt()));
        }
        for (int i = 0; i < numNodes; i++) {
            nodeInfoList.get(i).color = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < numNodes - 1; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            Set<Integer> uNeighbors = nodeInfoList.get(u).edges;
            uNeighbors.add(v);
            Set<Integer> vNeighbors = nodeInfoList.get(v).edges;
            vNeighbors.add(u);
        }
        scan.close();

        NodeInfo rootInfo = nodeInfoList.get(0);
        if (numNodes == 1) {
            return new TreeLeaf(rootInfo.value, rootInfo.color, 0);
        }

        TreeNode root = new TreeNode(rootInfo.value, rootInfo.color, 0);
        addChildren(root, rootInfo);
        return root;
    }

    /* Recursively adds children of a TreeNode */
    private static void addChildren(TreeNode parent, NodeInfo parentInfo) {
        for (Integer childNum : parentInfo.edges) {
            NodeInfo childNodeInfo = nodeInfoList.get(childNum);
            childNodeInfo.edges.remove(parentInfo.index);
            Tree tree;
            if (!childNodeInfo.edges.isEmpty()) {
                tree = new TreeNode(childNodeInfo.value, childNodeInfo.color, parent.getDepth() + 1);
            } else {
                tree = new TreeLeaf(childNodeInfo.value, childNodeInfo.color, parent.getDepth() + 1);
            }
            parent.addChild(tree);
            if (tree instanceof TreeNode) {
                addChildren((TreeNode) tree, childNodeInfo);
            }
        }
    }
