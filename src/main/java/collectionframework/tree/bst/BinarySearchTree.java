package collectionframework.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author te303950
 */
public class BinarySearchTree implements Tree {

	Node root = null;

	ArrayList<Integer> listPreOrder = new ArrayList<Integer>();
	ArrayList<Integer> listInOrder = new ArrayList<Integer>();
	ArrayList<Integer> listPostOrder = new ArrayList<Integer>();

	/**
	 * @param data
	 */
	@Override
	public void insertInBST(int data){
		root = insertInBST(root,data);
	}

	/**
	 *
	 * @param num
	 * @return
	 */
	@Override
	public boolean searchInBST(int num){
		return searchInBST(root,num);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Integer> getElementInBFSOrder() {

		ArrayList<Integer> list = new ArrayList<Integer>();

		if(root == null){
			System.err.println("Empty Tree");
		}else{

			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);

			while(!queue.isEmpty()){

				Node currentNode = queue.peek();
				list.add(currentNode.data);

				if(currentNode.left != null){
					queue.add(currentNode.left);
				}if(currentNode.right != null){
					queue.add(currentNode.right);
				}
				queue.remove();
			}
		}
		return list;
	}

	@Override
	public ArrayList<Integer> getElementInPreOrder() {

		 listPreOrder.clear();

		 getPreOrder(root);

		 return this.listPreOrder;

	}


	@Override
	public ArrayList<Integer> getElementInInOrder() {

		listInOrder.clear();

		getInOrder(root);

		return listInOrder;
	}

	@Override
	public ArrayList<Integer> getElementInPostOrder() {

		listPostOrder.clear();

		getPostOrder(root);

		return listPostOrder;
	}

	/**
	 *
	 * @param root
	 * @param data
	 * @return
	 */
	private Node insertInBST(Node root, int data){

		if(root == null ){
			root = getNewNode(data);
		}else if(data <= root.data){
			root.left = insertInBST(root.left, data);
		}else{
			root.right = insertInBST(root.right, data);
		}

		return root;
	}

	/**
	 * Insert the element in a BST non recursive manner
	 *
	 * @param num
	 */
	private void insertItrInBST(int num) {

		Node temp = root, parent = root;

		if (root == null) {
			root = getNewNode(num);
		} else {
			temp = root;

			while (temp != null) {
				if (num <= root.data) {
					parent = temp;
					temp = temp.left;
				} else {
					parent = temp;
					temp = temp.right;
				}
			}
			Node newNode = getNewNode(num);
			if (num <= parent.data) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		}
	}

	/*
	 *
	 */
	private Node getNewNode(int data) {

		Node temp = new Node();
		temp.data    = data;
		temp.left    = null;
		temp.right   = null;

		return temp;
	}



	/**
	 * @param root
	 * @param num
	 * @return
	 */
	private boolean searchInBST(Node root, int num) {

		boolean flag = false;

			if(root == null){
				return flag;

			}else if(root.data == num){
				flag = true;
				return flag;

			}else if(root.data < num){

				flag = searchInBST(root.right,num);
			}else{

				flag = searchInBST(root.left,num);
			}

		return flag;
	}

	/**
	 * Search elements in a tree in non recursive manner
	 *
	 * @param root
	 * @param num
	 * @return
	 */
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



	/*
	 *
	 */
	private void  getPreOrder(Node root) {


		if (root == null) {
			return;
		}

		listPreOrder.add(root.data);

		getPreOrder(root.left);
		getPreOrder(root.right);

	}


	/*
	 *
	 */
	private void  getInOrder(Node root) {

		if (root == null) {
			return;
		}

		getInOrder(root.left);

		listInOrder.add(root.data);

		getInOrder(root.right);

	}

	/*
	 *
	 */
	private void  getPostOrder(Node root) {

		if (root == null) {
			return;
		}

		getPostOrder(root.left);
		getPostOrder(root.right);
		listPostOrder.add(root.data);

	}

	@Override
	public int findMin() {

		int min = root.data ;

		Node temp = root;

		while(temp.left != null){
			temp = temp.left;
		}
		min = temp.data;

		return min;
	}

	@SuppressWarnings("unused")
	private int findMin(Node root){

		int min = 0;

		if(root == null){
		}else if(root.left == null){
			min = root.data;
		}else{
			Node temp = root;
			while(temp.left != null){
				temp = temp.left;
			}
			min = temp.data;
		}

		return min;

	}

	@Override
	public int findMax() {

		int max = root.data;

		Node temp = root;

		while(temp.right != null){
			temp = temp.right;
		}
		max = root.data;

		return max;
	}

	@Override
	public void deleteNode(int data) {


	}

	@SuppressWarnings("unused")
	private Node deleteNode(Node root, int data){

		/*if(root == null){
			return root;
		}else if(data < root.data){
			root.left = deleteNode(root.left, data);
		}else if(data > root.data){
			root.right = deleteNode(root.right, data);
		}else{
			if(root.left == null && root.right == null){
				root = null;
				return root;
			}else if(root.left == null){
				Node temp = root;
				root = root.right;
				temp = null;
				return root;
			}else if(root.right == null){
				Node temp = root;
				root = root.left;
				temp = null;
				return root;
			}else{
				Node temp = findMin(root.right);
			}

		}*/
		return null;
	}


	@Override
	public int getAncesterNode(int data){

		return getAncesterNode(root,data);

	}

	private int getAncesterNode(Node root, int value) {

		Node currentNode = searchElement(root, value);

		Node ansesterNode = root;

		while (ansesterNode != currentNode) {

			if (currentNode.data < ansesterNode.data) {
				ansesterNode = ansesterNode.left;
			}

			else {
				ansesterNode = ansesterNode.right;
			}

		}

		return ansesterNode.data;
	}

	private static Node searchElement(Node root, int element) {
		Node current = null;

		if (root == null) {
			System.out.println("Empty Root");
		}	else if (element == root.data) {
			// current = root;
			System.out.println("Number Also Found in BST");
		}else if (element < root.data) {
			current = searchElement(root.left, element);
		}else {
			current = searchElement(root.right, element);
		}
		return current;
	}

	public boolean isBST(Node root, int minVal, int maxVal){
		if (root == null) {
			return true;
		}
		if ((root.data > minVal) && (root.data < maxVal) && isBST(root.left, minVal, root.data)
				&& isBST(root.right, root.data, maxVal)) {
			return true;
		} else {
			return false;
		}
	}
	
}


