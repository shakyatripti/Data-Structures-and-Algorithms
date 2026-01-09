//Problem: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/





import java.io.*;
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int data) {
        val = data;
    }
}

class AverageOfSubtree {
    public int countNodes(TreeNode root) {
        int total = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
                int[] count = {0};
                int sum = subTreeSum(node, count);
                int avg = sum/count[0];
                if(avg == node.val) {
                    total++;
                }
            }
        }
        return total;
    }

    public int subTreeSum(TreeNode node, int[] count) {
        if(node==null) {
            return 0;
        }
        count[0]++;
        int left = subTreeSum(node.left, count);
        int right = subTreeSum(node.right, count);
        return left + right + node.val;
    }
}

class Main {
    public static void main(String[] args) {
        AverageOfSubtree subtree = new AverageOfSubtree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        System.out.println(subtree.countNodes(root));
        
        TreeNode root1 = new TreeNode(1);
        System.out.println(subtree.countNodes(root1));
    }
}