//Problem: https://leetcode.com/problems/binary-search-tree-iterator/description/


import java.util.*;
import java.io.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int data) {
		val = data;
		left = right = null;
	}
}

class BSTIterator {
	List<Integer> nodes = new ArrayList<>();
	Iterator itr = nodes.iterator();
	public BSTIterator(TreeNode root) {
		nodes = new ArrayList<>();
		inorderTraversal(root);
		Collections.sort(nodes);
		itr = nodes.iterator();
	}

	public void inorderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		inorderTraversal(root.left);
		nodes.add(root.val);
		inorderTraversal(root.right);
	}

	public int next() {
		int ans = (int) itr.next();
		return ans;
	}

	public boolean hasNext() {
		if(itr.hasNext()) {
			return true;
		}
		return false;
	}
}


class Main {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		BSTIterator tree = new BSTIterator(root);
		System.out.println(tree.hasNext());
		System.out.println(tree.next());
		System.out.println(tree.next());
	    System.out.println(tree.hasNext());
	    System.out.println(tree.next());
	    System.out.println(tree.next());
	    System.out.println(tree.next());
	    System.out.println(tree.hasNext());
	}
}