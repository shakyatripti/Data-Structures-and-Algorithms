//Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=problem-list-v2&envId=binary-tree

import java.util.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;
    Node(int v) {
        val=v;
        left=right=null;
    }
}

class LCA {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node node = root;
        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) {
            return root;
        }
        while(root!=null) {
            if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                node = root;
                return node;
            }
        }
        return node;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        LCA graph = new LCA();
        Node p = new Node(2);
        Node q = new Node(5);
        Node ans = graph.lowestCommonAncestor(root,p,q);
        System.out.println(ans.val);
    }
}