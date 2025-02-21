//Problem: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

class ContaminatedBinaryTree {
    Set<Integer> treeNodes = new HashSet<Integer>();
    public ContaminatedBinaryTree(Node root) {
        constructBinaryTree(root, 0);
    }
    
    public boolean findElements(int target) {
        if(treeNodes.contains(target)) {
            return true;
        }
        return false;
    }
    
    public void constructBinaryTree(Node root, int state) {
        if(root == null) {
            return;
        }
        root.data = state;
        treeNodes.add(state);
        constructBinaryTree(root.left, 2*state + 1);
        constructBinaryTree(root.right, 2*state + 2);
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(-1);
        root.left = new Node(-1);
        root.right = new Node(-1);
        root.left.left = new Node(-1);
        root.left.right = new Node(-1);
        ContaminatedBinaryTree tree = new ContaminatedBinaryTree(root);
        System.out.println(tree.findElements(1));
        System.out.println(tree.findElements(5));
        System.out.println(tree.findElements(3));
        
    }
}