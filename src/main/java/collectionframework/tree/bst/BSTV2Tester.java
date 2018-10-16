package collectionframework.tree.bst;

import java.util.List;

public class BSTV2Tester {
    public static void main(String args[]){

        BSTV2 bstv2 = new BSTV2();

        // Insert
        bstv2.insert(4);
        bstv2.insert(6);
        bstv2.insert(5);
        bstv2.insert(9);
        bstv2.insert(2);
        bstv2.insert(7);

        // Search
        bstv2.search(2);

        // left view
        List<Integer> leftView = bstv2.getLeftView();

        bstv2.getElementInInOrder();

    }
}
