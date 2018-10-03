package collectionframework.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class MergeKSortedLists {

    private static final Comparator<ListNode> listComparator =
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode x, ListNode y) {
                    return x.val - y.val;
                }
            };


    public static void main(String args[]) {

      //  ListNode node = mergeKLists();


    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, listComparator);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummyHead.next;
    }
}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                "next"+
                '}';
    }
}
