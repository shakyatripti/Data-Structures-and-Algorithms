//Problem: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

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

class LeftViewOfBinaryTree {
    public List<Integer> leftView(Node root) {
        List<Integer> leftViewTraversal = new ArrayList<>();
        if(root == null) {
            return leftViewTraversal;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int num = q.peek().data;
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            leftViewTraversal.add(num);
        }
        return leftViewTraversal;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        List<Integer> ans = tree.leftView(root);
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}