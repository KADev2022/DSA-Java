package udemy.dsa.tree;

import java.util.Stack;

/**
 * Class to model a Binary Tree.
 * 
 * @author Kazi Arham
 *
 */
public class BinaryTree {
	private TreeNode root;
	
	/**
	 * Inner class to model a tree node and this represents a Binary Tree.
	 * 
	 * @author Kazi Arham
	 *
	 */
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;	// Generic Type - data
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	/**
	 * Creates a Binary Tree.
	 */
	public void createBinaryTree() {
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		
		root = first;	// root ---> first
		first.left = second;
		first.right = third;	// second <--- first ---> third
		
		second.left = fourth;
	}
	
	/**
	 * Recursive Pre-Order traversal of a Binary Tree.
	 * 
	 * @param root The root node of the Binary Tree
	 */
	public void preOrderRecursive(TreeNode root) {
		// Base case
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	
	/**
	 * Iterative Pre-Order traversal of a Binary Tree.
	 */
	public void preOrderIterative() {
		// If the root node is null, return the method
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		/*
		 * Loop to check if stack is not empty.
		 * If it is true, then declare a TreeNode called temp and pop it from the stack
		 * Print out the temp's data.
		 */
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			
			// If the temp's right is not null, push it to the stack
			if (temp.right != null) {
				stack.push(temp.right);
			}
			
			// If the temp's left is not null, push it to the stack
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	
	/**
	 * Recursive In-Order traversal of a Binary Tree.
	 * 
	 * @param root The root node of the Binary Tree
	 */
	public void inOrderRecursive(TreeNode root) {
		// Base case
		if (root == null) {
			return;
		}
		
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}
	
	/**
	 * Iterative In-Order traversal of a Binary Tree.
	 * 
	 * @param root The root node of the Binary Tree
	 */
	public void inOrderIterative(TreeNode root) {
		// If the root node is null, return the method
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		
		/*
		 * Loop to check if the stack is not empty or temp is not null.
		 * If the condition is true, then do a condition statement to check if the temp node is not null.
		 * If that condition is true, push the temp to stack and point temp to its left subtree.
		 * Otherwise, pop the temp from the stack, print its data on the console and point temp to its right subtree.
		 */
		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	
	/**
	 * The main method of this application.
	 * 
	 * NOTE: This method can be edited if you want to call any of the methods above.
	 * 
	 * @param args The number of arguments
	 */
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.createBinaryTree();
		
		System.out.print("Pre Order Recursive: ");
		bt.preOrderRecursive(bt.root);
		System.out.println();
		
		System.out.print("Pre Order Iterative: ");
		bt.preOrderIterative();
		System.out.println();
		
		System.out.print("In Order Recursive: ");
		bt.inOrderRecursive(bt.root);
		System.out.println();
		
		System.out.print("In Order Iterative: ");
		bt.inOrderIterative(bt.root);
	}

}
