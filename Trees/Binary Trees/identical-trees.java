//Problem: https://leetcode.com/problems/same-tree/description/

//1st solution: Optimal Solution but with extra space complexity
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        left=right=null;
        data = val;
    }
}

class IdenticalTrees {
    public boolean checkIdenticalTrees(Node p, Node q) {
        List<Integer> firstTree = new ArrayList<>();
        List<Integer> secondTree = new ArrayList<>();
        preorder(p,firstTree);
        preorder(q,secondTree);
        if(firstTree.equals(secondTree)) {
            return true;
        }
        return false;
    }
    
    public static void preorder(Node root, List<Integer>pre) {
        if(root == null) {
            pre.add(null);
            return;
        }
        pre.add(root.data);
        preorder(root.left, pre);
        preorder(root.right, pre);
    }
}

class Main {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        Node root2 = new Node(1);
        root2.right = new Node(2);
        IdenticalTrees trees = new IdenticalTrees();
        System.out.println(trees.checkIdenticalTrees(root1, root2));
    }
}
                            
//2nd Solution: Optimal solution with O(1) space complexity

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        left=right=null;
        data = val;
    }
}

class IdenticalTrees {
    public boolean checkIdenticalTrees(Node p, Node q) {
        return preorderTraversal(p,q);
    }
    
    
    public boolean preorderTraversal(Node root, Node root2) {
        if(root == null && root2 == null) {
            return true;
        }
        if(root == null || root2 == null) {
            return false;
        }
        return (root.data == root2.data) && preorderTraversal(root.left, root2.left) && preorderTraversal(root.right, root2.right);
    }
}

class Main {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        Node root2 = new Node(1);
        root2.left = new Node(2);
        IdenticalTrees trees = new IdenticalTrees();
        System.out.println(trees.checkIdenticalTrees(root1, root2));
    }
}