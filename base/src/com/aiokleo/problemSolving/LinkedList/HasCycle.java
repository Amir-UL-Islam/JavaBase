package com.aiokleo.problemSolving.LinkedList;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}

public class HasCycle {

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(0);
        ListNode forthNode = new ListNode(-4);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = forthNode;
        forthNode.next = firstNode;

        Solutions solution = new Solutions();

        System.out.println(solution.hasCycle(firstNode));

    }
}

class Solutions {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;

    }

    public boolean hasCycleI(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (visitedNodes.contains(current)) {
                return true; // Cycle detected
            }
            visitedNodes.add(current);
            current = current.next;
        }

        return false; // No cycle detected
    }

    public boolean hasCycleII(ListNode head) {
        ListNode marker = new ListNode(0); // Dummy node to mark visited nodes

        ListNode current = head;
        while (current != null) {
            if (current.next == marker) {
                return true; // Cycle detected
            }
            ListNode nextNode = current.next;
            current.next = marker; // Mark the current node as visited
            current = nextNode;
        }

        return false; // No cycle detected
    }
}
