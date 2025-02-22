//Problem: https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/


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

class RecoverTreeFromPreorder {
    public TreeNode constructTree(String preorder) {
        int depth = 0, num = 0;
        Stack<TreeNode> st = new Stack<>();
        for(int i=0; i<preorder.length(); i++) {
            if(preorder.charAt(i)=='-') {
                depth++;
            } else {
                num = 10 * num + (preorder.charAt(i) - '0');
            }
            if(i+1 >=preorder.length() || (Character.isDigit(preorder.charAt(i)) && preorder.charAt(i+1)=='-')) {
                TreeNode node = new TreeNode(num);
                while(st.size() > depth) {
                    st.pop();
                }
                if(!st.isEmpty()) {
                    TreeNode parent = st.peek();
                    if(parent.left==null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                st.push(node);
                depth = 0;
                num = 0;
            }
        }
        
        TreeNode root = null;
        while(!st.isEmpty()) {
            root = st.pop();
        }
        
        return root;
    }
}

class Main {
    public static void main(String[] args) {
        String preorder = "11-2--3--4-5--6--7";
        RecoverTreeFromPreorder tree = new RecoverTreeFromPreorder();
        TreeNode root = tree.constructTree(preorder);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
    }
}