// Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

//1st Solution: Better Solution
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

class ZigZagTraversal {
    public List<List<Integer>> zigzag(Node root) {
        int counter = 1;
        List<List<Integer>> treeData = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) {
            return treeData;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int queueSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<queueSize; i++) {
                Node node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                currLevel.add(node.data);
            }
            if(counter%2 == 0) {
                Collections.reverse(currLevel);
            }
            treeData.add(currLevel);
            counter++;
        }
        return treeData;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ZigZagTraversal traversal = new ZigZagTraversal();
        List<List<Integer>> levels = traversal.zigzag(root);
        for(int i=0; i<levels.size(); i++) {
            for(int j=0; j<levels.get(i).size(); j++) {
                System.out.print(levels.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }
}
