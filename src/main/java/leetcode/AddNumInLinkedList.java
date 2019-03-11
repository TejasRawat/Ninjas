package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddNumInLinkedList {
    public static void main(String args[]) {

        Node l3 = new Node(3, null);
        Node l2 = new Node(4, l3);
        Node l1 = new Node(2, l2);

        Node p3 = new Node(4, null);
        Node p2 = new Node(6, p3);
        Node p1 = new Node(5, p2);

        Node sumNode = sumTwoNode(l1, p1);

    }

    private static Node sumTwoNode(Node firstNode, Node secondNode) {
        int sizeFirstNode = getListSize(firstNode);
        int sizeSecondNode = getListSize(secondNode);
        Node smallNode = sizeFirstNode > sizeSecondNode ? firstNode : secondNode;

        Node sumNode = new Node();

        return null;
    }


    private static int getListSize(Node node) {
        int len = 0;
        Node temp = node;
        while (null != temp) {
            len++;
            temp = temp.next;
        }
        return len;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
