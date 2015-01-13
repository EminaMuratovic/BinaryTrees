
public class BinarySearch {
	private Node root;
	
	public BinarySearch() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void add(int value) {
		if(root == null)
			root = new Node(value);
		else
			add(root, value);
	}
	
	private void add(Node current, int value) {
		if(current == null) {
			current = new Node(value);
			return;
		} // ovaj if NE RADI
		
		
		if(value <= current.value) {
			if(current.left == null) {
				current.left = new Node(value);
				return;
			}
			add(current.left, value);
		}
		else {
			if(current.right == null) {
				current.right = new Node(value);
				return;
			}
			add(current.right, value);
		}
	}
	public void print(){
		print(root);
	}
	
	private void print(Node root) {
		if(root == null)
			return;
		print(root.left);
		System.out.println(root.value);
		print(root.right);
	}
	
	public boolean contains(int value) {
		if(root.value == value)
			return true;
		return contains(root, value);
	}
	
	private boolean contains(Node current, int value) {
		if(current == null)
			return false;
		if(current.value == value)
			return true;
		if(value <= current.value)
			return contains(current.left, value);
		else
			return contains(current.right, value);
		
	}
	
	private class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
		
	}

}
