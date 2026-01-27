//class Node {
//    public Node previousNode;
//    public String data;
//    public Node nextNode;
//
//    public Node(String data) {
//        this.data = data;
//    }
//
//}
//
//public class OnePlusLinkedList {
//    Node head;
//
//    public OnePlusLinkedList(Node head) {
//        this.head = head;
//    }
//
//    public void print() {
//        Node currentNode = head; // is the starting point
//        while (currentNode != null) {
//            System.out.println(currentNode.data);
//            currentNode = currentNode.nextNode;
//        }
//    }
//
//    public static void main(String[] args) {
//        Node node1 = new Node("1");
//        Node node2 = new Node("2");
//        Node node3 = new Node("3");
//
//        node1.previousNode = null;
//        node1.nextNode = node2;
//        node2.previousNode = node1;
//        node2.nextNode = node3;
//        node3.previousNode = node2;
//        node3.nextNode = null;
//
//        OnePlusLinkedList list = new OnePlusLinkedList(node1);
//        list.print();
//
//    }
//
//}
