//Problem: https://leetcode.com/problems/build-an-array-with-stack-operations/description/




import java.io.*;
import java.util.*;

class BuildArray {
    public List<String> stackOperations(int[] target, int n) {
        List<String> ans = new ArrayList<String>();
        int i=0, curr = 1; 
        while(i!=target.length) {
            if(curr==target[i]) {
                ans.add("Push");
                i++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
            curr++;
        }
        return ans;
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        BuildArray arr = new BuildArray();
        int[] target = {1,3};
        List<String> ans = arr.stackOperations(target, 3);
        arr.display(ans);
        
        int[] target1 = {1,2,3};
        List<String> ans1 = arr.stackOperations(target1, 3);
        arr.display(ans1);
        
        int[] target2 = {1,2};
        List<String> ans2 = arr.stackOperations(target2, 4);
        arr.display(ans2);
    }
}