//Problem: https://leetcode.com/problems/root-equals-sum-of-children/description/



import java.io.*;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class RootEqualsChildren {
    public boolean checkTree(TreeNode root) {
        int left = root.left.data;
        int right = root.right.data;
        if(left + right == root.data) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        RootEqualsChildren tree = new RootEqualsChildren();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        System.out.println(tree.checkTree(root));
        
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(7);
        System.out.println(tree.checkTree(root1));
    }
}