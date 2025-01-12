//Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/

//1st solution: Brute Force Solution
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
    public Node searchBST(Node root, int val) {
        while(root!= null && root.data!=val) {
            if(root.data > val) {
                root = root.left;
            } else if(root.data < val) {
                root = root.right;
            }
        }
        return root;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.searchBST(root, 4));
    }
}

//2nd Solution: Optimal Solution
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
    public Node searchBST(Node root, int val) {
        if(root == null) {
            return null;
        }
        if(root.data == val) {
            return root;
        }
        if(root.data > val) {
           return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.searchBST(root, 6));
    }
}
