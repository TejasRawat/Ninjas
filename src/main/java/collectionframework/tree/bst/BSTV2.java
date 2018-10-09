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
        list.add(new LevelAndData(root,1));

        int level = 1;

        while (!list.isEmpty()) {
            System.out.println("*******************************");
            System.out.println(list);

            LevelAndData poll = list.poll();
            elements.add(poll);

            System.out.println("-------------------------------");
            System.out.println(elements);

            if (null != poll.getNode().left) {
                list.add(new LevelAndData(poll.getNode().left,poll.getLevel()+1));
            }
            if (null != poll.getNode().right) {
                list.add(new LevelAndData(poll.getNode().right,poll.getLevel()+1));
            }
            
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(LevelAndData  levelAndData : elements){
            if(!map.containsKey(levelAndData.getLevel())){
                map.put(levelAndData.getLevel(),levelAndData.getNode().data);
            }
        }

        return null;
    }


    @Override
    public ArrayList<Integer> getElementInBFSOrder() {
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
    public ArrayList<Integer> getElementInPreOrder() {
        return null;
    }

    @Override
    public ArrayList<Integer> getElementInInOrder() {
        return null;
    }

    @Override
    public ArrayList<Integer> getElementInPostOrder() {
        return null;
    }

    @Override
    public int findMin() {
        return 0;
    }

    @Override
    public int findMax() {
        return 0;
    }

    @Override
    public void deleteNode(int data) {

    }

    @Override
    public int getAncesterNode(int data) {
        return 0;
    }

    @Override
    public int getHeight() {
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
