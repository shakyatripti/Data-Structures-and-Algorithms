//Problem: https://leetcode.com/problems/print-binary-tree/description/




import java.io.*;
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int data) {
        val = data;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode n, int r, int c) {
        node = n;
        row = r;
        col = c;
    }
}

class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int m = heightOfTree(root);
        int n = (int) Math.pow(2, m) - 1;
        String[][] ans = new String[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(ans[i], "-");
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, (n-1)/2));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair topNode = q.poll();
                TreeNode node = topNode.node;
                int row = topNode.row;
                int col = topNode.col;
                ans[row][col] = String.valueOf(node.val);
                if(node.left!=null) {
                    int c = col - (int) (Math.pow(2, m-row-2));
                    q.add(new Pair(node.left, row+1, c));
                }
                if(node.right!=null) {
                    int c = col + (int) (Math.pow(2, m-row-2));
                    q.add(new Pair(node.right, row+1, c));
                }
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i=0; i<m; i++) {
            res.add(new ArrayList<>());
            for(int j=0; j<n; j++) {
                res.get(i).add(ans[i][j]);
            }
        }
        return res;
    }
    
    public int heightOfTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
    
    public void display(List<List<String>> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        PrintBinaryTree tree = new PrintBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        List<List<String>> ans = tree.printTree(root);
        tree.display(ans);
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        List<List<String>> ans1 = tree.printTree(root1);
        tree.display(ans1);
    }
}