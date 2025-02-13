//Problem: https://leetcode.com/problems/cousins-in-binary-tree/description/


//Brute force solution
import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        val = data;
        left=right=null;
    }
}

class CousinsOfBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int level = 0;
        HashMap<Integer, Pair> mp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        mp.put(root.val, new Pair(-1, -1));
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left!=null) {
                    q.add(node.left);
                    mp.put(node.left.val, new Pair(level, node.val));
                }
                if(node.right!=null) {
                    q.add(node.right);
                    mp.put(node.right.val, new Pair(level, node.val));
                }
            }
        }
        Pair cousinsOfX = mp.get(x);
        Pair cousinsOfY = mp.get(y);
        if((cousinsOfX.depth == cousinsOfY.depth) && (cousinsOfX.parent != cousinsOfY.parent)) {
            return true;
        }
        return false;
    }
}

class Pair {
    int depth;
    int parent;
    Pair(int d, int p) {
        depth = d;
        parent = p;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        CousinsOfBinaryTree tree = new CousinsOfBinaryTree();
        System.out.println(tree.isCousins(root,3,4));
        System.out.println(tree.isCousins(root1,4,5));
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
        left=right=null;
    }
}

class CousinsOfBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                int parent = 0;
                if(node.left!=null) {
                    q.add(node.left);
                    if(node.left.val == x || node.left.val == y) {
                        parent++;
                        level++;
                    }
                }
                if(node.right!=null) {
                    q.add(node.right);
                    if(node.right.val == x || node.right.val == y) {
                        parent++;
                        level++;
                    }
                }
                if(parent==2) {
                    return false;
                }
            }
            if(level==1) {
                return false;
            }
            if(level==2) {
                return true;
            }
        }
        return true;
    }
}

class Pair {
    int depth;
    int parent;
    Pair(int d, int p) {
        depth = d;
        parent = p;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        CousinsOfBinaryTree tree = new CousinsOfBinaryTree();
        System.out.println(tree.isCousins(root,3,4));
        System.out.println(tree.isCousins(root1,4,5));
    }
}