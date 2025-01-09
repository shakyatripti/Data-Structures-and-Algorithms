//Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/

//1st solution: BruteForce Solution 

class Pair {
    TreeNode node;
    int state;
    Pair(TreeNode n, int s) {
        node = n;
        state = s;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 1, maxDepth=0;
        Stack<Pair> st = new Stack<Pair>();
        if(root == null) {
            return maxDepth;
        }
        st.push(new Pair(root, depth));
        while(!st.isEmpty()) {
           Pair topElement = st.pop();
           depth++;
           if(topElement.node.left != null) {
               st.push(new Pair(topElement.node.left, depth));
           }
           if(topElement.node.right != null) {
                st.push(new Pair(topElement.node.right, depth));
           }
           if(topElement.node.left == null && topElement.node.right == null) {
                if(topElement.state > maxDepth) {
                    maxDepth = topElement.state;
                }
                if(!st.isEmpty()) {
                    depth = st.peek().state;
                }
           }
        }
        return maxDepth;
    }
}

//2nd Solution: Better Solution

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
        left=right=null;
    }
}

class HeightOfBinaryTree {
    public int maxDepth(Node root) {
        int depth=0;
        Queue<Node> q = new LinkedList<>();
        if(root == null) {
            return depth;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int queueSize = q.size();
            depth++;
            for(int i=0; i<queueSize; i++) {
                Node node = q.poll();
                if(node.left !=null) {
                    q.add(node.left);
                }
                if(node.right !=null) {
                    q.add(node.right);
                }
            }
        }
        return depth;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        System.out.println(tree.maxDepth(root));
    }
}

//3rd Solution: Optimal Solution
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
