//Problem: https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/


//Brute Force Solution
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

class CheckCompleteness {
    public boolean isCompleteTree(Node root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        Set<Integer> treeNodes = new HashSet<Integer>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair pairNode = q.poll();
                int state = pairNode.state;
                treeNodes.add(state);
                Node curr = pairNode.node;
                if(curr.left!=null) {
                    q.add(new Pair(curr.left, 2*state + 1));
                }
                if(curr.right!=null) {
                    q.add(new Pair(curr.right, 2*state + 2));
                }
            }
        }
        int count = 0;
        for(int i: treeNodes) {
            if(i!=count) {
                return false;
            }
            count++;
        }
        return true;
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

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(3);
        CheckCompleteness tree = new CheckCompleteness();
        System.out.println(tree.isCompleteTree(root));
        Node root1 = new Node(2);
        root1.left = new Node(6);
        root1.right = new Node(3);
        root1.right.right = new Node(5);
        System.out.println(tree.isCompleteTree(root1));
    }
}
