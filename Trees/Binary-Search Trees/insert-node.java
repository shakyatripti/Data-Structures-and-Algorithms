//Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

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

class BinarySearchTree {
    List<Integer> insertedNodes = new ArrayList<Integer>();
    public List<Integer> insertIntoBST(Node root, int val) {
        Node initialRoot = root, insertNode = null;
        if(root == null) {
            root = new Node(val);
            return insertedNodes;
        }
        while(root!=null) {
            insertNode = root;
            if(root.data > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if(insertNode.data > val) {
            insertNode.left = new Node(val);
        } else {
            insertNode.right = new Node(val);
        }
        traversal(initialRoot);
        return insertedNodes;
    }
    
    public void traversal(Node root) {
        if(root == null) {
            return;
        }
        insertedNodes.add(root.data);
        traversal(root.left);
        traversal(root.right);
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.right = new Node(7);
        root.right.right = new Node(8);
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> traversal = tree.insertIntoBST(root,6);
        for(int elements: traversal) {
            System.out.print(elements + " ");
        }
    }
}