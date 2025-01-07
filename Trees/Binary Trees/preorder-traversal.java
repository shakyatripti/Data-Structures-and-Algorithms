import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int key) {
        data = key;
        left=right= null;
    }
}

class PreOrderTraversal {
    public static void preorder(Node root, List preorderValues) {
        if(root == null) {
            return;
        }
        preorderValues.add(root.data);
        preorder(root.left, preorderValues);
        preorder(root.right, preorderValues);
    }
}

class Main {
    public static void main(String[] args) {
        PreOrderTraversal tree = new PreOrderTraversal();
        Node root = new Node(1);
        root.right = new Node(2);
        root.left = new Node(4);
        root.right.left = new Node(3);
        root.right.left.right = new Node(6);
        root.right.left.left = new Node(5);
        List<Integer> values = new ArrayList<Integer>();
        tree.preorder(root,values);
        for(int i=0; i<values.size(); i++) {
            System.out.println(values.get(i));
        }
    } 
}