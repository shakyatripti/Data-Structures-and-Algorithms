//Problem: https://leetcode.com/problems/validate-binary-tree-nodes/?envType=problem-list-v2&envId=tree

import java.util.*;
import java.io.*;

class ValidateBinaryTree {
    public boolean isBinaryTree(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;
        while(!q.isEmpty()) {
            int t = q.poll();
            int left = leftChild[t];
            int right = rightChild[t];
            if((left!=-1 && visited[left]) || (right!=-1 && visited[right])) {
                return false;
            }
            if(left!=-1 && !visited[left]) {
                q.add(left);
                visited[left] = true;
            }
            if(right!=-1 && !visited[right]) {
                q.add(right);
                visited[right] = true;
            }
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int findRoot(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> roots = new HashSet<Integer>();
        for(int i=0; i<n; i++) {
            roots.add(i);
        }
        for(int i=0; i<leftChild.length; i++) {
            roots.remove(leftChild[i]);
        }
        for(int i=0; i<rightChild.length; i++) {
            roots.remove(rightChild[i]);
        }
        Iterator<Integer> itr = roots.iterator();
        return roots.size() == 1 ? itr.next() : -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[] leftChild = new int[]{1,-1,-1,4,-1,-1};
        int[] rightChild = new int[]{2,-1,-1,5,-1,-1};
        ValidateBinaryTree tree = new ValidateBinaryTree();
        System.out.println(tree.isBinaryTree(6,leftChild, rightChild));
    }
}