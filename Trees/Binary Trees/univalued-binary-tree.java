//Problem:https://leetcode.com/problems/univalued-binary-tree/description/




import java.io.*;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        this.val = data;
    }
}


class UnivaluedBinaryTree {
    HashSet<Integer> st = new HashSet<>();
    public boolean isUnival(TreeNode root) {
        DFS(root);
        if(st.size()==1) {
            return true;
        }
        return false;
    }

    public void DFS(TreeNode root) {
        if(root==null) {
            return;
        }
        DFS(root.left);
        st.add(root.val);
        DFS(root.right);
    }
}

class Main {
    public static void main(String[] args) {
        UnivaluedBinaryTree tree = new UnivaluedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(tree.isUnival(root));
        
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(2);
        System.out.println(tree.isUnival(root1));
    }
}