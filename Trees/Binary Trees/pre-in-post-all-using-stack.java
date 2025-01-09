//Problem: Preorder Inorder Postorder Traversals in One Traversal

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

class AllTraversalInOne {
    public List<List<Integer>> allTraversal(Node root) {
        List<List<Integer>> traversals = new ArrayList<List<Integer>>();
        List<Integer> preorder = new ArrayList<Integer>();
        List<Integer> postorder = new ArrayList<Integer>();
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<Pair> st = new Stack<Pair>();
        if(root == null) {
            return traversals;
        }
        st.push(new Pair(root, 1));
        while(!st.isEmpty()) {
            Pair itr = st.pop();
            if(itr.state == 1) {
                preorder.add(itr.node.data);
                itr.state++;
                st.push(new Pair(itr.node, itr.state));
                if(itr.node.left != null) {
                    st.push(new Pair(itr.node.left, 1));
                }
            } else if(itr.state == 2) {
                inorder.add(itr.node.data);
                itr.state++;
                st.push(new Pair(itr.node, itr.state));
                if(itr.node.right !=null) {
                    st.push(new Pair(itr.node.right, 1));
                }
            } else {
                postorder.add(itr.node.data);
            }
        }
        traversals.add(preorder);
        traversals.add(inorder);
        traversals.add(postorder);
        return traversals;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        AllTraversalInOne tree = new AllTraversalInOne();
        List<List<Integer>> traversals = tree.allTraversal(root);
        for(int i=0; i<traversals.size(); i++) {
            for(int j=0; j<traversals.get(i).size(); j++) {
                System.out.print(traversals.get(i).get(j) + " ");
            }
            System.out.println("\n");
        }
    }
}