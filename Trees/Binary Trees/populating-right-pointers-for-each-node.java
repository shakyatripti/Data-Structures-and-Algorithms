//Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
//Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/


import java.io.*;
import java.util.*;

class Node {
    Node left;
    Node right;
    Node next;
    int val;
    Node(int data) {
        val = data;
        left = right = next = null;
    }
}

class PopulatingNextPointer {
    public Node nextPointer(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(i!=size-1) {
                    node.next = q.peek();
                }
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
        }
        return root;
    }
    
    public void printLevels(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node.next == null) {
                    System.out.print(node.val + " " + null + " ");
                } else {
                    System.out.print(node.val + " " + node.next.val + " ");
                }
                if(node.left!=null) {
                   q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        PopulatingNextPointer tree = new PopulatingNextPointer();
        Node node = tree.nextPointer(root);
        tree.printLevels(node);
        
    }
}