package collectionframework.tree.bst;

public class NewTreeTester {
    public static void main(String args[]) {

        BST bst = new BST();
/*
        bst.insertItrInBST(1);
        bst.insertItrInBST(2);
        bst.insertItrInBST(3);*/

        bst.insert(4);
        bst.insert(3);
        bst.insert(9);
        bst.insert(6);
        bst.insert(7);
        bst.insert(6);

        bst.getHeight();


      //  Arrays.parallelSort();

    }
}
