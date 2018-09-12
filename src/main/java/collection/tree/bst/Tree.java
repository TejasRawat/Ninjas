package collection.tree.bst;

import java.util.ArrayList;

/**
 * 
 * @author te303950
 */
public interface Tree{
	
	public void insertInBST(int data);
	
	public boolean searchInBST(int num);
	
	public ArrayList<Integer>getElementInBFSOrder();
	
	public ArrayList<Integer>getElementInPreOrder();
	
	public ArrayList<Integer>getElementInInOrder();
	
	public ArrayList<Integer>getElementInPostOrder();
	
	public int findMin();
	
	public int findMax();
	
	public void deleteNode(int data);
	
	public int getAncesterNode(int data);
	
}
