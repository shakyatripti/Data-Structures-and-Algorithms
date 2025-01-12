//Problem: https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

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
    public int findCeil(Node root, int val) {
        int ceil = -1;
        while(root!=null) {
            if(root.data < val) {
                root = root.right;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.left.right.right.right = new Node(7);
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.findCeil(root,6));
    }
}