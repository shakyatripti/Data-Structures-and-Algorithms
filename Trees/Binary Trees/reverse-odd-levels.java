//Problem: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/


//Brute force solution
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

class ReverseOddLevels {
    public TreeNode reverseLevel(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> oddLevels = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(level%2!=0) {
                    oddLevels.add(node);
                }
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
            if(level%2!=0) {
                for(int i=0; i<oddLevels.size()/2; i++) {
                    TreeNode firstNode = oddLevels.get(i);
                    TreeNode secondNode = oddLevels.get(oddLevels.size()-1-i);
                    int temp = firstNode.val;
                    firstNode.val = secondNode.val;
                    secondNode.val = temp;
                }
            }
            level++;
        }
        return root;
    }
    
    public void print(TreeNode root) {
        if(root==null) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(22);
        root.right.right = new TreeNode(12);
        ReverseOddLevels tree = new ReverseOddLevels();
        TreeNode node = tree.reverseLevel(root);
        tree.print(node);
    }
}

