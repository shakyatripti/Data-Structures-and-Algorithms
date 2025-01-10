//Problem: https://leetcode.com/problems/diameter-of-binary-tree/description/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data=val;
        left=right=null;
    }
}

class CalculateHeight {
    int diameter = 0;
    public int heightOfBinaryTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight= heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        diameter = Math.max(diameter, leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public int diameterOfBinaryTree(Node root) {
        heightOfBinaryTree(root);
        return diameter;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.left.right = new Node(8);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        CalculateHeight tree = new CalculateHeight();
        int diameter = tree.diameterOfBinaryTree(root);
        System.out.println(diameter);
    }
}