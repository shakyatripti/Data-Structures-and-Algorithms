//Problem: https://leetcode.com/problems/balanced-binary-tree/description/




import java.io.*;
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int data) {
        val = data;
    }
    TreeNode() {}
}

class BinaryTree {
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) > 1) {
                return false;
            }
        }
        return true;
    }

    public int findHeight(TreeNode root) {
        if(root==null) {
            return -1;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public void dfs(TreeNode root) {
        if(root==null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        arr.add(Math.abs(right-left));
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTree tree = new BinaryTree();
        System.out.println(tree.isBalanced(root));
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(4);
        BinaryTree tree1 = new BinaryTree();
        System.out.println(tree1.isBalanced(root1));
        
        TreeNode root2 = new TreeNode();
        BinaryTree tree2 = new BinaryTree();
        System.out.println(tree2.isBalanced(root2));
        
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.right.right = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        root3.right.right.right = new TreeNode(4);
        BinaryTree tree3 = new BinaryTree();
        System.out.println(tree3.isBalanced(root3));
        
    }
}