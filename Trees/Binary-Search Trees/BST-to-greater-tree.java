//Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/description/


import java.io.*;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class GreaterSumBST {
    public TreeNode greaterSumTree(TreeNode root) {
        int[] sum = {0};
        findDfs(root, sum);
        return root;
    }
    
    public void findDfs(TreeNode root, int[] sum) {
        if(root==null) {
            return;
        }
        findDfs(root.right, sum);
        sum[0]+=root.data;
        root.data = sum[0];
        findDfs(root.left, sum);
    }
    
    public void printNodes(TreeNode root) {
        if(root==null) {
            return;
        }
        System.out.println(root.data);
        printNodes(root.left);
        printNodes(root.right);
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        GreaterSumBST tree = new GreaterSumBST();
        TreeNode node = tree.greaterSumTree(root);
        tree.printNodes(node);
    }
}