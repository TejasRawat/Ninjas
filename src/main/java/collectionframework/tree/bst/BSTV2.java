package collectionframework.tree.bst;

import java.util.*;

public class BSTV2 implements Tree {

    Node root;

    @Override
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = getNewNode(data);
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }


    public Node getNewNode(int data) {
        Node node = new Node(data, null, null);
        return node;
    }

    @Override
    public boolean search(int num) {
        return search(root, num);
    }

    public boolean search(Node root, int num) {
        if (root == null) {
            return false;
        }

        if (num == root.data) {
            return true;
        } else if (num < root.data) {
            return search(root.left, num);
        } else {
            return search(root.right, num);
        }
    }

    @Override
    public List<Integer> getLeftView() {
        if (root == null) {
            return null;
        }
        List<LevelAndData> elements = new LinkedList<LevelAndData>();

        LinkedList<LevelAndData> list = new LinkedList<LevelAndData>();
        list.add(new LevelAndData(root, 1));

        int level = 1;

        while (!list.isEmpty()) {
            System.out.println("*******************************");
            System.out.println(list);

            LevelAndData poll = list.poll();
            elements.add(poll);

            System.out.println("-------------------------------");
            System.out.println(elements);

            if (null != poll.getNode().left) {
                list.add(new LevelAndData(poll.getNode().left, poll.getLevel() + 1));
            }
            if (null != poll.getNode().right) {
                list.add(new LevelAndData(poll.getNode().right, poll.getLevel() + 1));
            }

        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (LevelAndData levelAndData : elements) {
            if (!map.containsKey(levelAndData.getLevel())) {
                map.put(levelAndData.getLevel(), levelAndData.getNode().data);
            }
        }

        return null;
    }

    @Override
    public int findMin() {
        Node temp = root;
        while (null != temp.left) {
            temp = temp.left;
        }
        return temp.data;
    }

    @Override
    public int findMax() {
        Node temp = root;
        while (null != temp.right) {
            temp = temp.right;
        }
        return temp.data;
    }

    @Override
    public List<Integer> getElementInBFSOrder() {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> elements = new ArrayList<Integer>();
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);

        while (!list.isEmpty()) {
            Node firstNode = list.poll();

            elements.add(firstNode.data);

            if (null != firstNode.left) {
                list.add(firstNode.left);
            }
            if (null != firstNode.right) {
                list.add(firstNode.right);
            }
        }
        return elements;
    }

    @Override
    public int getHeight() {
        return findHeight(root);
    }

    private int findHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return maxOf(findHeight(root.left), findHeight(root.right)) + 1;
        }
    }

    private int maxOf(int leftHeight, int rightHeight) {
        if (leftHeight >= rightHeight) {
            return leftHeight;
        } else {
            return rightHeight;
        }
    }

    @Override
    public List<Integer> getElementInPreOrder() {
        List<Integer> list = new ArrayList<Integer>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(Node root, List<Integer> list) {
        if(null == root){
            return;
        }
        list.add(root.data);
        inOrder(root.left,list);
        inOrder(root.right,list);
    }

    @Override
    public List<Integer> getElementInInOrder() {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root,list);
        return list;
    }

    private void inOrder(Node root, List<Integer> list) {
        if(null == root){
            return;
        }
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }

    @Override
    public List<Integer> getElementInPostOrder() {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root,list);
        return list;
    }

    private void postOrder(Node root, List<Integer> list) {
        if(null == root){
            return;
        }
        inOrder(root.left,list);
        inOrder(root.right,list);
        list.add(root.data);
    }

    @Override
    public int getLowestCommonAncestor(int n1, int n2) {
        Node lcaNode = getLCA(root,n1,n2);
        return lcaNode.data;
    }

    private Node getLCA(Node root, int n1, int n2) {
        if(Objects.isNull(root)){
            return null;
        }
        if(root.data < maxOf(n1,n2)){
            return getLCA(root.left,n1,n2);
        }
        if(root.data > minOf(n1,n2)){
            return getLCA(root.right,n1,n2);
        }
        return root;
    }
    private int minOf(int n1, int n2) {
        return n1 < n2 ? n1 : n2;
    }

    @Override
    public void deleteNode(int data) {

    }

    @Override
    public int getAncesterNode(int data) {
        return 0;
    }



}

class LevelAndData {
    private final Node node;
    private final int level;

    public LevelAndData(Node node, int level) {
        this.node = node;
        this.level = level;
    }

    public Node getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "LevelAndData{" +
                "node=" + node +
                ", level=" + level +
                '}';
    }
}
