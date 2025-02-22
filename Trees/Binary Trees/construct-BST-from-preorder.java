//Problem: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/


//Brute force solution
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

class ConstructBSTFromPreorder {
    public TreeNode constructBST(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode orgRoot = root;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        for(int i=1; i<preorder.length; i++) {
            if(preorder[i] < st.peek().data) {
                root.left = new TreeNode(preorder[i]);
                st.push(root.left);
                root = root.left;
            } else {
                while(!st.isEmpty() && preorder[i] > st.peek().data) {
                    root = st.pop();
                }
                root.right = new TreeNode(preorder[i]);
                st.push(root.right);
                root = root.right;
            }
        }
        return orgRoot;
    }
}

class Main {
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        ConstructBSTFromPreorder tree = new ConstructBSTFromPreorder();
        TreeNode root = tree.constructBST(preorder);
        System.out.println(root.data);
        System.out.println(root.right.data);
        System.out.println(root.left.data);
    }
}