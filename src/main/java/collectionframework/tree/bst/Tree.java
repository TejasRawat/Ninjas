package collectionframework.tree.bst;

import java.util.*;

/**
 * 
 * @author te303950
 */
public interface Tree{
	
	public void insert(int data);
	
	public boolean search(int num);
	
	public ArrayList<Integer>getElementInBFSOrder();
	
	public ArrayList<Integer>getElementInPreOrder();
	
	public ArrayList<Integer>getElementInInOrder();
	
	public ArrayList<Integer>getElementInPostOrder();
	
	public int findMin();
	
	public int findMax();
	
	public void deleteNode(int data);
	
	public int getAncesterNode(int data);

	public int getHeight();

	public List<Integer> getLeftView();
}
