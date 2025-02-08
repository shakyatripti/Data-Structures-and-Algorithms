//Problem: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/


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

class EvenValuedGrandParent {
    public int sumEvenGrandParent(TreeNode root) {
        if(root.left==null && root.right==null) {
            return 0;
        }
        int sum = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,null,null));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Tuple topEle = q.poll();
                TreeNode node = topEle.node;
                TreeNode parent = topEle.parent;
                TreeNode grandParent = topEle.grandParent;
                if(grandParent!=null && grandParent.val%2==0) {
                    sum+=node.val;
                }
                if(node.left!=null) {
                    q.add(new Tuple(node.left, node, parent));
                }
                if(node.right!=null) {
                    q.add(new Tuple(node.right, node, parent));
                }
            }
        }
        return sum;
    }
    
}

class Tuple {
    TreeNode node;
    TreeNode parent;
    TreeNode grandParent;
    Tuple(TreeNode n, TreeNode p, TreeNode gp) {
        node = n;
        parent = p;
        grandParent = gp;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(1);
        EvenValuedGrandParent parent = new EvenValuedGrandParent();
        System.out.println(parent.sumEvenGrandParent(root));
    }
}


//Optimal solution
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

class EvenValuedGrandParent {
    public int sumEvenGrandParent(TreeNode root) {
        if(root.left==null && root.right==null) {
            return 0;
        }
        int[] sum = {0};
        findDfs(root,null,null,sum);
        return sum[0];
    }
    
    public void findDfs(TreeNode node, TreeNode parent, TreeNode grandParent, int[] sum) {
        if(node==null) {
            return;
        }
        if(grandParent!=null && grandParent.val%2==0) {
            sum[0]+=node.val;
        }
        findDfs(node.left,node,parent,sum);
        findDfs(node.right,node,parent,sum);
    }
    
}


class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(1);
        EvenValuedGrandParent parent = new EvenValuedGrandParent();
        System.out.println(parent.sumEvenGrandParent(root));
    }
}