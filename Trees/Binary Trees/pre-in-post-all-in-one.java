//Problem: Preorder Inorder Postorder Traversals in One Traversal

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

class DFS {
    public static void dfs(Node root, List<Integer> preorder, List<Integer> inorder, List<Integer> postorder) {
        if(root==null) {
            return;
        }
        preorder.add(root.data);
        dfs(root.left,preorder,inorder,postorder);
        inorder.add(root.data);
        dfs(root.right, preorder,inorder,postorder);
        postorder.add(root.data);
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.left = new Node(2);
        root.right.right = new Node(6);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        List<Integer> inorder = new ArrayList<Integer>();
        List<Integer> postorder = new ArrayList<Integer>();
        List<Integer> preorder = new ArrayList<Integer>();
        DFS traversal = new DFS();
        traversal.dfs(root,preorder,inorder,postorder);
        for(int elements: preorder) {
            System.out.print(elements + " ");
        }
        System.out.println("\n");
        for(int elements: inorder) {
            System.out.print(elements + " ");
        }
        System.out.println("\n");
        for(int elements: postorder) {
            System.out.print(elements + " ");
        }
        
    }
}