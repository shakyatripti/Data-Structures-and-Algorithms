//Problem: https://leetcode.com/problems/create-binary-tree-from-descriptions/description/




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

class CreateBinaryTree {
    public TreeNode createFromDesc(int[][] descriptions) {
        HashSet<Integer> st = new HashSet<>();
        HashMap<Integer, int[]> mp = new HashMap<>();
        for(int i=0; i<descriptions.length; i++) {
            st.add(descriptions[i][0]);
            if(mp.containsKey(descriptions[i][0])) {
                int[] child = mp.get(descriptions[i][0]);
                child[descriptions[i][2]] = descriptions[i][1];
                
            } else {
                int[] child = new int[2];
                child[descriptions[i][2]] = descriptions[i][1];
                mp.put(descriptions[i][0], child);
            }
        }
        for(int i=0; i<descriptions.length; i++) {
            if(st.contains(descriptions[i][1])) {
                st.remove(descriptions[i][1]);
            }
        }
        Iterator<Integer> it = st.iterator();
        TreeNode root = new TreeNode(it.next());
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int[] child = mp.get(node.val);
            if(child!=null && child[1]!=0) {
                TreeNode leftChild = new TreeNode(child[1]);
                node.left = leftChild;
                q.add(leftChild);
            }
            if(child!=null && child[0]!=0) {
                TreeNode rightChild = new TreeNode(child[0]);
                node.right = rightChild;
                q.add(rightChild);
            }
        }
        return root;
    }
    
    public void display(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if(node.left!=null) {
                q.add(node.left);
            }
            if(node.right!=null) {
                q.add(node.right);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        CreateBinaryTree tree = new CreateBinaryTree();
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root = tree.createFromDesc(descriptions);
        tree.display(root);
        
        System.out.println();
        
        int[][] descriptions1 = {{1,2,1},{2,3,0},{3,4,1}};
        TreeNode root1 = tree.createFromDesc(descriptions1);
        tree.display(root1);
    }
}