//Problem: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/




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

class BinaryTree {
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        int ans = 0, maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size(), sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
            levelSum.add(sum);
        }

        for(int i=0; i<levelSum.size(); i++) {
            if(levelSum.get(i) > maxSum) {
                maxSum = levelSum.get(i);
                ans = i+1;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(tree.maxLevelSum(root));
        
        TreeNode root1 = new TreeNode(989);
        root1.right = new TreeNode(10250);
        root1.right.left = new TreeNode(98693);
        root1.right.right = new TreeNode(-89388);
        root1.right.right.right = new TreeNode(-32127);
        System.out.println(tree.maxLevelSum(root1));
        
        TreeNode root2 = new TreeNode(-100);
        root2.left = new TreeNode(-200);
        root2.right = new TreeNode(-300);
        root2.left.left = new TreeNode(-20);
        root2.left.left = new TreeNode(-5);
        root2.right.left = new TreeNode(-10);
        System.out.println(tree.maxLevelSum(root2));
    }
}