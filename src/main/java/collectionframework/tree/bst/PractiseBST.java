package collectionframework.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PractiseBST implements Tree {

	private Node root = null;
	private ArrayList<Integer> treeInList  = new ArrayList<Integer>();

	@Override
	public void insertInBST(int data) {
	//	root = insertRecsInBST(data,root);
		insertItrInBST(data);
	}

	private Node insertRecsInBST(int data, Node root) {
		if(root == null){
			root = getNewNode(data);
		}else if(data <= root.data){
			root.left = insertRecsInBST(data, root.left);
		}else{
			root.right = insertRecsInBST(data, root.right);
		}
		return root;
	}

	private Node getNewNode(int data) {
		Node node = new Node(data,null,null);
		return node;
	}

	private void insertItrInBST(int num){

		Node temp = root,parent = root;

		if(root == null){
			root = getNewNode(num);
		}else{
			temp = root;

			while(temp != null){
				if(num <= root.data){
					parent = temp;
					temp = temp.left;
				}else{
					parent = temp;
					temp = temp.right;
				}
			}
			Node newNode = getNewNode(num);
			if(num <= parent.data){
				parent.left = newNode;
			}else{
				parent.right = newNode;
			}
		}
	}

	@Override
	public boolean searchInBST(int num){
		return searchItrInBST(root,num);
	}

	private boolean searchRecrInBST(Node left, int num) {
		if (root == null) {
			return false;
		} else if (num == root.data) {
			return true;
		} else if (num < root.data) {
			return searchRecrInBST(root.left, num);
		} else {
			return searchRecrInBST(root.right, num);
		}
	}

	private boolean searchItrInBST(Node root, int num){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()){
			Node currntNode = queue.peek();

			if(currntNode.data == num){
				return true;
			}
			if(currntNode.left != null){
				queue.add(currntNode.left);
			}
			if(currntNode.right != null){
				queue.add(currntNode.right);
			}
			queue.remove();
		}
		return false;
	}



	@Override
	public ArrayList<Integer> getElementInBFSOrder() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(queue.isEmpty()){
			Node currentNode = queue.peek();
			list.add(currentNode.data);

			if(currentNode.left != null){
				queue.add(currentNode.left);
			}if(currentNode.right != null){
				queue.add(currentNode.right);
			}
			queue.remove();
		}
		return list;
	}

	@Override
	public ArrayList<Integer> getElementInPreOrder() {

		treeInList.clear();

		getPreOrder(root);

		return treeInList;
	}

	private void getPreOrder(Node root) {

		if(root == null){
			return;
		}
		treeInList.add(root.data);
		getPreOrder(root.left);
		getPreOrder(root.right);
	}

	@Override
	public ArrayList<Integer> getElementInInOrder() {

		treeInList.clear();
		getInOrder(root);

		return treeInList;
	}

	private void getInOrder(Node root) {

		if(root == null){
			return;
		}
		getInOrder(root.left);
		treeInList.add(root.data);
		getInOrder(root.right);
	}

	@Override
	public ArrayList<Integer> getElementInPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteNode(int data) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAncesterNode(int data) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public static void main(String args[]) {

		PractiseBST tree = new PractiseBST();
		tree.insertInBST(4);
		tree.insertInBST(5);
		tree.insertInBST(2);
		tree.insertInBST(3);
		tree.insertInBST(6);
		tree.insertInBST(6);
		tree.insertInBST(12);
		tree.insertInBST(23);
		tree.insertInBST(13);
		tree.insertInBST(1);
		tree.insertInBST(7);
		tree.insertInBST(223);
		tree.insertInBST(14);
		tree.insertInBST(25);
		
		System.out.println("Pre Order");
		System.out.println(tree.getElementInPreOrder());
		
		System.out.println("In Order");
		System.out.println(tree.getElementInInOrder());
	}
}

