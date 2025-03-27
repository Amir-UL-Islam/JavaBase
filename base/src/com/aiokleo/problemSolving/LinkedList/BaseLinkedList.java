class Node {
    public String data;
    public Node nextNode;

    public Node(String data) {
        this.data = data;
    }

}

public class BaseLinkedList {
    Node head;

    public BaseLinkedList(Node head) {
        this.head = head;
    }

    public void add(Node newNode) {
        Node currentNode = head;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = newNode;
    }

    public void print() {
        Node currentNode = head; // is the starting point
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
    }

    public void printII() { // What would happens if I use currentNode.nextNode != null instead
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.nextNode) {
            System.out.println(currentNode.data);
        }
    }

    public int size() {
        int size = 0;
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.nextNode) {
            size += 1;
        }
        return size;
    }

    public Node get(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    public int search(String value) {
        int size = 0;
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.nextNode) {
            if (currentNode.data == value) {
                return size; // No need to break here as I am Using Return;
            } // What would happens if Nothing Found
            size += 1;
        }
        return -1;
    }

    public void delete(int index) {
        Node currentNode = head;
        if (index == 0) {
            this.head = currentNode.nextNode;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
    }

    public void insert(int index, String value) {
        Node newNode = new Node(value);
        Node currentNode = head;
        if (index == 0) {
            newNode.nextNode = currentNode;
            this.head = newNode; // Reassigning the Head;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");

        // node1.nextNode = node2;
        // node2.nextNode = node3;
        // node3.nextNode = node4;

        BaseLinkedList list = new BaseLinkedList(node1);
        // Alternatively, you can use the addNode method to add nodes dynamically:
        list.add(node2);
        list.add(node3);
        list.add(node4);

        //list.insert(2, "6");
        //list.insert(0, "6");
        //list.insert(2, "6");

        //Node node5 = new Node("5");

        list.insert(3, "5");

        list.print();
        //System.out.println("After Deletion");

        //list.delete(0);

        //// Print the list
        //list.print();

    }

}
