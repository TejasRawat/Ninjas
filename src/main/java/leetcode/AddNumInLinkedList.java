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
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(2, l2);

        ListNode p3 = new ListNode(4, null);
        ListNode p2 = new ListNode(6, p3);
        ListNode p1 = new ListNode(5, p2);

        ListNode sumListNode = sumTwoNode(l1, p1);

    }

    private static ListNode sumTwoNode(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;

        while (l1 != null || l2 != null)
        {
            sum = carry + (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new ListNode(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
