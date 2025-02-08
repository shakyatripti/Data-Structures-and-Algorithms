//Problem: https://leetcode.com/problems/even-odd-tree/description/


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

class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
            if(level%2==0) {
                for(int i=0; i<currLevel.size()-1; i++) {
                    if(currLevel.get(i)>=currLevel.get(i+1) && currLevel.get(i)%2==0) {
                        return false;
                    }
                }
                if(currLevel.get(currLevel.size()-1)%2==0) {
                    return false;
                }
            } else {
                for(int i=0; i<currLevel.size()-1; i++) {
                    if(currLevel.get(i)<=currLevel.get(i+1) && currLevel.get(i)%2!=0) {
                        return false;
                    }
                }
                if(currLevel.get(currLevel.size()-1)%2!=0) {
                    return false;
                }
            }
            level++;
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(12);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        EvenOddTree tree = new EvenOddTree();
        System.out.println(tree.isEvenOddTree(root));
        
        TreeNode root1 = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left = new TreeNode(9);
        root1.right.left = new TreeNode(7);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        System.out.println(tree.isEvenOddTree(root1));
    }
}