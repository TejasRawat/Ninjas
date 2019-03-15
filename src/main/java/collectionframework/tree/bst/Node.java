package collectionframework.tree.bst;

public class Node {

    int data;
    Node left;
    Node right;

    public Node() {

    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        int leftVal;
        int rightVal;

        if (left != null) {
            leftVal = left.data;
        } else {
            leftVal = Integer.MIN_VALUE;
        }

        if (right != null) {
            rightVal = right.data;
        } else {
            rightVal = Integer.MAX_VALUE;
        }

        return "ListNode{" +
                "data=" + data +
                ", left=" + leftVal +
                ", right=" + rightVal +
                '}';
    }
}
