// Problem: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

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

class Pair {
    Node node;
    int state;
    Pair(Node n, int s) {
        node = n;
        state = s;
    }
}

class TopViewOfBinaryTree {
    public List<Integer> topView(Node root) {
        List<Integer> topViewTraversal = new ArrayList<>();
        TreeMap<Integer, Integer> traversal = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        if(root == null) {
            return topViewTraversal;
        }
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair val = q.poll();
                if(val.node.left != null) {
                    q.add(new Pair(val.node.left, val.state - 1));
                }
                if(val.node.right != null) {
                    q.add(new Pair(val.node.right, val.state + 1));
                }
                if(!traversal.containsKey(val.state)) {
                    traversal.put(val.state, val.node.data);
                }
            }
        }
        for(Map.Entry entry: traversal.entrySet()) {
            Integer nodeData = (Integer) entry.getValue();
            topViewTraversal.add(nodeData);
        }
        return topViewTraversal;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(30);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);
        TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
        List<Integer> topViewData = tree.topView(root);
        for(int i=0; i<topViewData.size(); i++) {
            System.out.print(topViewData.get(i) + " ");
        }
    }
}