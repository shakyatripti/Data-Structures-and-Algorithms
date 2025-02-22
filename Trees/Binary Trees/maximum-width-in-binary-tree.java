//Problem: https://leetcode.com/problems/maximum-width-of-binary-tree/description/


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

class Pair {
    int state;
    TreeNode node;
    Pair(TreeNode n, int s) {
        node = n;
        state = s;
    }
}

class MaximumWidthBinaryTree {
    public int maxWidth(TreeNode root) {
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()) {
            int size = q.size();
            int minstate = Integer.MAX_VALUE, maxstate = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                Pair pairNode = q.poll();
                int state = pairNode.state;
                minstate = Math.min(minstate, state);
                maxstate = Math.max(maxstate, state);
                TreeNode node = pairNode.node;
                if(node.left!=null) {
                    q.add(new Pair(node.left, 2*state + 1));
                }
                if(node.right!=null) {
                    q.add(new Pair(node.right, 2*state + 2));
                }
            }
            width = Math.max(width, maxstate - minstate);
        }
        return width + 1;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(10);
        root.right.right.left = new TreeNode(9);
        MaximumWidthBinaryTree tree = new MaximumWidthBinaryTree();
        System.out.println(tree.maxWidth(root));
    }
}