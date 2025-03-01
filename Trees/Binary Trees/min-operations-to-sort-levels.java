//Problem: https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/


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

class MinOperationsToSort {
    public int minimumOperations(TreeNode root) {
        int operations = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                arr[i] = node.data;
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
            operations+=countSwaps(arr);
        }
        return operations;
    }
    
    public int countSwaps(int[] arr1) {
        int[] arr2 = arr1.clone();
        Arrays.sort(arr2);
        int swaps = 0;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<arr1.length; i++) {
            mp.put(arr1[i], i);
        }
        
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i]!=arr2[i]) {
                int temp = arr1[i];
                arr1[i] = arr2[i];
                int index = mp.get(arr1[i]);
                arr1[index] = temp;
                mp.put(arr1[i], i);
                mp.put(arr1[index], index);
                swaps++;
            }
        }
        return swaps;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        MinOperationsToSort tree = new MinOperationsToSort();
        System.out.println(tree.minimumOperations(root));
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(11);
        root1.left.right = new TreeNode(12);
        System.out.println(tree.minimumOperations(root1));
    }
}