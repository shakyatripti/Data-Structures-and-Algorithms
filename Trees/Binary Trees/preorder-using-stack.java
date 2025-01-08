//Problem: https://leetcode.com/problems/binary-tree-preorder-traversal/description/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
    }
}

class Preorder {
    public List<Integer> preorderStack (Node root) {
        List<Integer> preorderTraverse = new ArrayList<Integer>();
        Stack<Node> s = new Stack<>();
        if(root == null) {
            return preorderTraverse;
        }
        s.push(root);
        while(!s.isEmpty()) {
            Node top = s.pop();
            if(top.right != null) {
                s.push(top.right);
            }
            if(top.left !=null) {
                s.push(top.left);
            }
            preorderTraverse.add(top.data);
        }
        return preorderTraverse;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(9);
        root.left.left.right.left = new Node(1);
        root.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);
        root.right.right.left = new Node(8);
        Preorder tree = new Preorder();
        List<Integer> preorderVal = tree.preorderStack(root);
        for(int values: preorderVal) {
            System.out.println(values);
        }
    }
}