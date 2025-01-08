//Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;
    Node(int val) {
        data = val;
    }
}

class InorderTraversal {
    public List<Integer> inorderStack(Node root) {
        List<Integer> inorderVal = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node treeNode = root;
        while(true) {
            if(treeNode != null) {
                s.push(treeNode);
                treeNode = treeNode.left;
            } else {
                if(s.isEmpty()) {
                    break;
                }
                treeNode = s.pop();
                inorderVal.add(treeNode.data);
                treeNode = treeNode.right;
            }
        }
        return inorderVal;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(9);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right = new Node(8);
        InorderTraversal tree = new InorderTraversal();
        List<Integer> inorderValues = tree.inorderStack(root);
        for(int val: inorderValues) {
            System.out.println(val);
        }
    }
}