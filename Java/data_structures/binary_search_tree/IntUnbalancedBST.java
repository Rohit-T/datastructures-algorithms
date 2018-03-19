public class IntUnbalancedBST{
	private IntBSTNode root;

	class IntBSTNode{
		private int value;
		private IntBSTNode left, right;

		IntBSTNode(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		IntBSTNode getLeft() {
			return left;
		}

		IntBSTNode getRight() {
			return right;
		}

		int getValue() {
			return value;
		}
	}

	public IntUnbalancedBST() {
		root = null;
	}

	public IntUnbalancedBST(int val) {
		root = createNode(val);
	}

	//Recursive Insert
	public void add(int val) {
		root = add(root, val);
	}

	private IntBSTNode add(IntBSTNode bstNode, int val) {
		if(bstNode == null) {
			return createNode(val);
		}
		if(val <= bstNode.value){
			bstNode.left = add(bstNode.left, val);
		}else {
			bstNode.right = add(bstNode.right, val);
		}
		return bstNode;
	}

	// Iterative Insert
	public void insert(int val) {
		IntBSTNode node = createNode(val);
		if(root == null) {
			root = node;
			return;
		}
		IntBSTNode currentNode = root;
		while(currentNode != null) {
			if(val <= currentNode.value){
				if(currentNode.left == null){
					currentNode.left = node;
					break;
				}else {
					currentNode = currentNode.left;
					continue;
				}
			}else {
				if(currentNode.right == null){
					currentNode.right = node;
					break;
				}else {
					currentNode = currentNode.right;
					continue;
				}
			}
		}
	}

	private IntBSTNode createNode(int val) {
		return new IntBSTNode(val);
	}

	// Search Recursive
	public boolean search(int value) {
		return search(root, value);
	}

	private boolean search(IntBSTNode bstNode, int val) {
		if(bstNode == null) {
			return false;
		}
		if(val < bstNode.value) {
			return search(bstNode.left, val);
		}else if( val > bstNode.value) {
			return search(bstNode.right, val);
		}else {
			return true;
		}
	}

	public IntBSTNode getRoot() {
		return root;
	}

	//Iterative
	public int findMin() throws ItemDoesNotExistsException{
		if(root == null) {
			throw new ItemDoesNotExistsException("Min does not exists");
		}
		IntBSTNode currentNode = root;
		while(currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.value;
	}

	//Iterative
	public int findMax() throws ItemDoesNotExistsException{
		if(root == null) {
			throw new ItemDoesNotExistsException("Max does not exists");
		}
		IntBSTNode currentNode = root;
		while(currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return currentNode.value;
	}
}