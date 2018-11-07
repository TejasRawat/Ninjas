package collectionframework.tree.bst;

import java.util.List;

/**
 * 
 * @author te303950
 */
public interface Tree{
	public void insert(int data);
	public boolean search(int num);
	public List<Integer>getElementInBFSOrder();
	public List<Integer>getElementInPreOrder();
	public List<Integer>getElementInInOrder();
	public List<Integer> getLeftView();
	public List<Integer>getElementInPostOrder();
	public int findMin();
	public int findMax();
	public int getHeight();
	public int getLowestCommonAncestor(int num1,int num2);

	// Not Implemented
	public void deleteNode(int data);
	public int getAncesterNode(int data);
}
