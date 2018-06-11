package HackerRank.CrackingTheCodingInterview;

import java.util.HashSet;

public class DetectACycle {

    public static void main(String[] args) {
        DetectACycle detectACycle = new DetectACycle();
        detectACycle.test();
    }

    private void test() {
        Node node0 = new Node(0, null);
        if (hasCycle(node0)) throw new AssertionError();
        if (hasCycleFastSlow(node0)) throw new AssertionError();
        if (hasCycleIterations(node0)) throw new AssertionError();

        Node node1 = new Node(0, null);
        Node node2 = new Node(1, null);
        Node node3 = new Node(2, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        if (!hasCycle(node1)) throw new AssertionError();
        if (!hasCycleFastSlow(node1)) throw new AssertionError();
        if (!hasCycleIterations(node1)) throw new AssertionError();
    }

    // Trade off for size. O(N)
    private boolean hasCycle(Node head) {
        HashSet<Node> nodes = new HashSet();

        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
            }
            head = head.next;
        }

        return false;
    }

    // Lower storage if large list O(N)
    private boolean hasCycleFastSlow(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }

    // Only works if constrain given of size. O(N)
    private boolean hasCycleIterations(Node head) {
        int i = 0;

        while (head != null && i < 101) {
            head = head.next;
            i++;
        }

        return head != null;
    }

    private class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
