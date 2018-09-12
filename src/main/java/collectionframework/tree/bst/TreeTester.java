package collectionframework.tree.bst;

import java.util.ArrayList;

public class TreeTester {
	public static void main(String[] args) {
			
		
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insertInBST(15);
		tree.insertInBST(5);
		tree.insertInBST(10);
		tree.insertInBST(8);
		tree.insertInBST(7);
		tree.insertInBST(4);
		
		System.out.println(tree.searchInBST(15));
		
		ArrayList<Integer> list= tree.getElementInBFSOrder();
		System.out.println("BFS Order"+list);
		
		
		ArrayList<Integer> listPreOrder = tree.getElementInPreOrder();
		System.out.println("PreOrder"+listPreOrder);
		
		ArrayList<Integer> listInOrder = tree.getElementInInOrder();
		System.out.println("listInOrder"+listInOrder);
		
		ArrayList<Integer> listPostOrder = tree.getElementInPostOrder();
		System.out.println("listPostOrder"+listPostOrder);
		
		System.out.println("Min element in Tree : "+tree.findMin());
		System.out.println("Min element in Tree : "+tree.findMax());
		
		
		
	}
}
