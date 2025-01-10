//Problem: https://leetcode.com/problems/symmetric-tree/description/

//1nd Solution: Optimal solution with O(1) space complexity
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

class SymmetricTree {
    public boolean isSymmetric(Node root) {
        return checkSymmetry(root.left, root.right);
    }
    
    public boolean checkSymmetry(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && checkSymmetry(root1.left, root2.right) && checkSymmetry(root1.right, root2.left);
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(20);
        root.left = new Node(30);
        root.right.right = root.left.left = new Node(30);
        root.right.left = root.left.right = new Node(40);
        SymmetricTree tree = new SymmetricTree();
        System.out.println(tree.isSymmetric(root));
    }
}