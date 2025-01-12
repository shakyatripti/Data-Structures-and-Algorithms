
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
    public int maxNodeInBST(Node root) {
        int max=0;
        while(root!= null) {
            max = root.data;
            root = root.right;
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.maxNodeInBST(root));
    }
}