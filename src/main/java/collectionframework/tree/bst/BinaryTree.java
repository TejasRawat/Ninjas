package collectionframework.tree.bst;

import java.util.ArrayList;

public class BinaryTree implements Tree {

    Node node = null;
    private ArrayList<Integer> preOrderList ;
    private ArrayList<Integer> inOrderList ;
    private ArrayList<Integer> postOrderList ;


    @Override
    public void insert(int data) {



    }

    @Override
    public boolean search(int num) {




        return false;
    }

    @Override
    public ArrayList<Integer> getElementInBFSOrder() {


        return null;
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
