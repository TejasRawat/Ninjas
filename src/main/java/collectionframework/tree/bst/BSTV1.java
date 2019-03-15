package collectionframework.tree.bst;

/**
 * @author te303950
 */
public class BSTV1 {

    /*ListNode root = null;

    ArrayList<Integer> listPreOrder = new ArrayList<Integer>();
    ArrayList<Integer> listInOrder = new ArrayList<Integer>();
    ArrayList<Integer> listPostOrder = new ArrayList<Integer>();

    *//**
     * @param data
     *//*
    @Override
    public void insert(int data) {
        root = insertInBST(root, data);
    }

    *//**
     * @param num
     * @return
     *//*
    @Override
    public boolean search(int num) {
        return searchInBST(root, num);
    }

    *//**
     *
     *//*
    @Override
    public ArrayList<Integer> getElementInBFSOrder() {

        ArrayList<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            System.err.println("Empty Tree");
        } else {

            Queue<ListNode> queue = new LinkedList<ListNode>();
            queue.add(root);

            while (!queue.isEmpty()) {

                ListNode currentNode = queue.peek();
                list.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
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

    *//**
     * @param root
     * @param data
     * @return
     *//*
    private ListNode insertInBST(ListNode root, int data) {

        if (root == null) {
            root = getNewNode(data);
        } else if (data <= root.data) {
            root.left = insertInBST(root.left, data);
        } else {
            root.right = insertInBST(root.right, data);
        }

        return root;
    }




    *//**
     * Insert the element in a BSTV1 non recursive manner
     *
     * @param num
     *//*
    public void insertItrInBST(int num) {

        ListNode temp = root, parent = root;

        if (root == null) {
            root = getNewNode(num);
        } else {
            while (temp != null) {
                if (num <= temp.data) {
                    parent = temp;
                    temp = temp.left;
                } else {
                    parent = temp;
                    temp = temp.right;
                }
            }

            ListNode newNode = getNewNode(num);
            if (num <= parent.data) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    *//*
     *
     *//*
    private ListNode getNewNode(int data) {

        ListNode temp = new ListNode();
        temp.data = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }


    *//**
     * @param root
     * @param num
     * @return
     *//*
    private boolean searchInBST(ListNode root, int num) {

        boolean flag = false;

        if (root == null) {
            return flag;

        } else if (root.data == num) {
            flag = true;
            return flag;

        } else if (root.data < num) {

            flag = searchInBST(root.right, num);
        } else {

            flag = searchInBST(root.left, num);
        }

        return flag;
    }

    *//**
     * Search elements in a tree in non recursive manner
     *
     * @param root
     * @param num
     * @return
     *//*
    private boolean searchItrInBST(ListNode root, int num) {
        Queue<ListNode> queue = new LinkedList<ListNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ListNode currntNode = queue.peek();

            if (currntNode.data == num) {
                return true;
            }
            if (currntNode.left != null) {
                queue.add(currntNode.left);
            }
            if (currntNode.right != null) {
                queue.add(currntNode.right);
            }
            queue.remove();
        }
        return false;
    }


    *//*
     *
     *//*
    private void getPreOrder(ListNode root) {


        if (root == null) {
            return;
        }

        listPreOrder.add(root.data);

        getPreOrder(root.left);
        getPreOrder(root.right);

    }


    *//*
     *
     *//*
    private void getInOrder(ListNode root) {

        if (root == null) {
            return;
        }

        getInOrder(root.left);

        listInOrder.add(root.data);

        getInOrder(root.right);

    }

    *//*
     *
     *//*
    private void getPostOrder(ListNode root) {

        if (root == null) {
            return;
        }

        getPostOrder(root.left);
        getPostOrder(root.right);
        listPostOrder.add(root.data);

    }

    @Override
    public int findMin() {

        int min = root.data;

        ListNode temp = root;

        while (temp.left != null) {
            temp = temp.left;
        }
        min = temp.data;

        return min;
    }

    @SuppressWarnings("unused")
    private int findMin(ListNode root) {

        int min = 0;

        if (root == null) {
        } else if (root.left == null) {
            min = root.data;
        } else {
            ListNode temp = root;
            while (temp.left != null) {
                temp = temp.left;
            }
            min = temp.data;
        }

        return min;

    }

    @Override
    public int findMax() {

        int max = root.data;

        ListNode temp = root;

        while (temp.right != null) {
            temp = temp.right;
        }
        max = root.data;

        return max;
    }

    @Override
    public void deleteNode(int data) {


    }

    @SuppressWarnings("unused")
    private ListNode deleteNode(ListNode root, int data) {

		*//*if(root == null){
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
				ListNode temp = root;
				root = root.right;
				temp = null;
				return root;
			}else if(root.right == null){
				ListNode temp = root;
				root = root.left;
				temp = null;
				return root;
			}else{
				ListNode temp = findMin(root.right);
			}

		}*//*
        return null;
    }


    @Override
    public int getAncesterNode(int data) {

        return getAncesterNode(root, data);

    }

    private int getAncesterNode(ListNode root, int value) {

        ListNode currentNode = searchElement(root, value);

        ListNode ansesterNode = root;

        while (ansesterNode != currentNode) {

            if (currentNode.data < ansesterNode.data) {
                ansesterNode = ansesterNode.left;
            } else {
                ansesterNode = ansesterNode.right;
            }

        }

        return ansesterNode.data;
    }

    private static ListNode searchElement(ListNode root, int element) {
        ListNode current = null;

        if (root == null) {
            System.out.println("Empty Root");
        } else if (element == root.data) {
            // current = root;
            System.out.println("Number Also Found in BSTV1");
        } else if (element < root.data) {
            current = searchElement(root.left, element);
        } else {
            current = searchElement(root.right, element);
        }
        return current;
    }

    public boolean isBST(ListNode root, int minVal, int maxVal) {
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

    @Override
    public int getHeight() {
        return findHeight(root);
    }

    @Override
    public List<Integer> getLeftView() {
        return null;
    }

    private int findHeight(ListNode root) {
        if (root == null) {
            return -1;
        } else {
            return maxOf(findHeight(root.left), findHeight(root.right)) + 1;
        }
    }

    private int maxOf(int leftHeight, int rightHeight) {
        if (leftHeight >= rightHeight) {
            return leftHeight;
        } else {
            return rightHeight;
        }
    }*/
}


