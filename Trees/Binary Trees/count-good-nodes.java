//Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/


//Brute Force solution
import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        val = data;
        left = right = null;
    }
}

class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        int count = 0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, root.val));
        while(!st.isEmpty()) {
            int size = st.size();
            for(int i=0; i<size; i++) {
                Pair topEle = st.pop();
                int state = topEle.state;
                TreeNode node = topEle.node;
                if(state <= node.val) {
                    count++;
                    state = node.val;
                }
                if(node.right!=null) {
                    st.push(new Pair(node.right, state));
                }
                if(node.left!=null) {
                    st.push(new Pair(node.left, state));
                }
            }
        }
        return count;
    }
}

class Pair {
    TreeNode node;
    int state;
    Pair(TreeNode n, int s) {
        node = n;
        state = s;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        CountGoodNodes nodes = new CountGoodNodes();
        System.out.println(nodes.goodNodes(root));
    }
}

//Optimal Solution
import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        val = data;
        left = right = null;
    }
}

class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        int[] count = {0};
        findDfs(root, root.val, count);
        return count[0];
    }
    
    public void findDfs(TreeNode root, int max, int[] count) {
        if(root == null) {
            return;
        }
        if(max<=root.val) {
            count[0]++;
            max = root.val;
        }
        findDfs(root.left,max,count);
        findDfs(root.right,max,count);
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        CountGoodNodes nodes = new CountGoodNodes();
        System.out.println(nodes.goodNodes(root));
    }
}