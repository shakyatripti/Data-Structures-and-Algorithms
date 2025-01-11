//Problem: https://leetcode.com/problems/binary-tree-right-side-view/description/

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

class RightViewOfBinaryTree {
    public List<Integer> rightView(Node root) {
        List<Integer> rightViewTraversal = new ArrayList<>();
        if(root == null) {
            return rightViewTraversal;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int num = 0;
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                num = node.data;
            }
            rightViewTraversal.add(num);
        }
        return rightViewTraversal;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(7);
        root.left.left.left = new Node(8);
        root.right = new Node(4);
        root.right.right = new Node(5);
        RightViewOfBinaryTree tree = new RightViewOfBinaryTree();
        List<Integer> ans = tree.rightView(root);
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}