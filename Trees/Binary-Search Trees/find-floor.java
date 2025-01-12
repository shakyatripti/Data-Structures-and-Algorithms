//Problem: https://www.geeksforgeeks.org/problems/floor-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-bst

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
    public int findFloor(Node root, int val) {
        int floor = -1;
        while(root!=null) {
            if(root.data == val) {
                floor = root.data;
                return floor;
            }
            if(root.data > val) {
                root = root.left;
            }
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
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
        System.out.println(tree.findFloor(root,6));
    }
}