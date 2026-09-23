//Problem: https://leetcode.com/problems/evaluate-boolean-binary-tree/description/



import java.io.*;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        int ans = DFS(root);
        if(ans==1) {
            return true;
        }
        return false;
    }

    public int DFS(TreeNode root) {
        if(root==null) {
            return -1;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        if(left==-1 && right==-1) {
            return root.val;
        }
        if((left==1 || right==1) && root.val==2) {
            return 1;
        }
        if(left==1 && right==1 && root.val==3) {
            return 1;
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        BooleanBinaryTree tree = new BooleanBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(tree.evaluateTree(root));
        
        TreeNode root1 = new TreeNode(0);
        System.out.println(tree.evaluateTree(root1));
    }
}