//Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
    }
}

class BFS {
    public List<List<Integer>> levelwisetraversal(Node root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) {
            return levels;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int queuesize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<queuesize; i++) {
                if(q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if(q.peek().right !=null) {
                    q.add(q.peek().right);
                }
                currLevel.add(q.poll().data);
            }
            levels.add(currLevel);
        }
        return levels;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        root.right.right.right = new Node(4);
        root.right.right.left = new Node(22);
        BFS bfs = new BFS();
        List<List<Integer>> levels = bfs.levelwisetraversal(root);
        Iterator itr = levels.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}