//Problem: https://leetcode.com/problems/cousins-in-binary-tree-ii/description/


//Brute Force solution
import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        val = data;
        left = right = null;
    }
}

class CousinsInBT {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root.left == null && root.right == null) {
            root.val = 0;
            return root;
        }
        int level = 0, sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            sum = 0;
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
            mp.put(level, sum);
            level++;
        }
        
        level = 0;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                sum = 0;
                TreeNode node = q.poll();
                if(node.left!=null) {
                    sum+=node.left.val;
                    q.add(node.left);
                }
                if(node.right!=null) {
                    sum+=node.right.val;
                    q.add(node.right);
                }
                if(node.left!=null) {
                    node.left.val = mp.get(level+1) - sum;
                }
                if(node.right!=null) {
                    node.right.val = mp.get(level+1) - sum;
                }
            }
            level++;
        }
        root.val = 0;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        CousinsInBT tree = new CousinsInBT();
        TreeNode node = tree.replaceValueInTree(root);
        tree.print(node);
    }
}



//Optimal solution
import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        val = data;
        left = right = null;
    }
}

class CousinsInBT {
    public TreeNode replaceValueInTree(TreeNode root) {
        int prevSum = root.val, currSum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            currSum = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                sum = 0;
                if(node.left!=null) {
                    sum+=node.left.val;
                }
                if(node.right!=null) {
                    sum+=node.right.val;
                }
                if(node.left!=null) {
                    node.left.val = sum;
                    q.add(node.left);
                }
                if(node.right!=null) {
                    node.right.val = sum;
                    q.add(node.right);
                }
                currSum+=sum;
                node.val = prevSum - node.val;
            }
            prevSum = currSum;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        CousinsInBT tree = new CousinsInBT();
        TreeNode node = tree.replaceValueInTree(root);
        tree.print(node);
    }
}