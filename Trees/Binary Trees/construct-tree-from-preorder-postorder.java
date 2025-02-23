//Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/


import java.util.*;
import java.io.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class ConstructTreeFromPrePost {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int[] index = {0};
        return constructTree(preorder, postorder, index, 0, preorder.length-1);
    }
    
    public TreeNode constructTree(int[] pre, int[] post, int[] index, int l, int r) {
        if(index[0] >= pre.length || l > r) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index[0]]);
        index[0]++;
        if(l==r) {
            return root;
        }
        int i;
        for(i=l; i<=r; i++) {
            if(pre[index[0]]==post[i]) {
                break;
            }
        }
        if(l<=r) {
            root.left = constructTree(pre,post,index,l,i);
            root.right = constructTree(pre,post,index,i+1,r-1);
        }
        return root;
    }
    
    public void print(TreeNode root) {
        if(root == null) {
            return;
        }
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
}

class Main {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        ConstructTreeFromPrePost tree = new ConstructTreeFromPrePost();
        TreeNode root = tree.constructFromPrePost(preorder, postorder);
        tree.print(root);
    }
}

