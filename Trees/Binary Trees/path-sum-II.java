//Problem: https://leetcode.com/problems/path-sum-ii/description/


//Brute Force Solution
import java.util.*;
import java.io.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left=right= null;
    }
}

class PathSum {
    public List<List<Integer>> printPaths(TreeNode root, int target) {
        List<List<Integer>> targetPaths = new ArrayList<List<Integer>>();
        if(root==null) {
            return targetPaths;
        }
        Stack<Tuple> st = new Stack<>();
        st.push(new Tuple(root,root.data,new ArrayList<>(Arrays.asList(root.data))));
        while(!st.isEmpty()) {
            int size = st.size();
            for(int i=0; i<size; i++) {
                Tuple topEle = st.pop();
                int sum = topEle.sum;
                TreeNode node = topEle.node;
                List<Integer> path = topEle.paths;
                if(node.right!=null) {
                    int rightSum = sum + node.right.data;
                    List<Integer> rightPaths = new ArrayList<>(path);
                    rightPaths.add(node.right.data);
                    st.push(new Tuple(node.right,rightSum,rightPaths));
                }
                if(node.left!=null) {
                    int leftSum = sum + node.left.data;
                    List<Integer> leftPaths = new ArrayList<>(path);
                    leftPaths.add(node.left.data);
                    st.push(new Tuple(node.left,leftSum,leftPaths));
                }
                if(sum==target && node.left==null && node.right==null) {
                    targetPaths.add(path);
                }
            }
        }
        return targetPaths;
    }
}

class Tuple {
    TreeNode node;
    int sum;
    List<Integer> paths;
    Tuple(TreeNode n, int s, List<Integer> p) {
        node = n;
        sum = s;
        paths = p;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        PathSum tree = new PathSum();
        List<List<Integer>> paths = tree.printPaths(root, 22);
        for(int i=0; i<paths.size();i++) {
            for(int ele: paths.get(i)) {
                System.out.print(ele +  " ");
            }
            System.out.print("\n");
        }
    }
}


//Optimal solution
import java.util.*;
import java.io.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left=right= null;
    }
}

class PathSum {
    public List<List<Integer>> printPaths(TreeNode root, int target) {
        List<List<Integer>> targetPaths = new ArrayList<List<Integer>>();
        List<Integer> subPaths = new ArrayList<Integer>();
        allTargetPaths(root,target,subPaths,targetPaths);
        return targetPaths;
    }
    public void allTargetPaths(TreeNode node, int sum, List<Integer> subPath, List<List<Integer>> paths) {
        if(node==null) {
            return;
        }
        subPath.add(node.data);
        if(sum==node.data && node.left==null && node.right==null) {
            paths.add(new ArrayList<>(subPath));
        }
        allTargetPaths(node.left, sum - node.data, subPath, paths);
        allTargetPaths(node.right, sum - node.data, subPath, paths);
        subPath.remove(subPath.size()-1);
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        PathSum tree = new PathSum();
        List<List<Integer>> paths = tree.printPaths(root, 27);
        for(int i=0; i<paths.size();i++) {
            for(int ele: paths.get(i)) {
                System.out.print(ele +  " ");
            }
            System.out.print("\n");
        }
    }
}