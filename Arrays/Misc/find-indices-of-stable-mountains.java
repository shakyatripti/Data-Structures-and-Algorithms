//Problem: https://leetcode.com/problems/find-indices-of-stable-mountains/description/




import java.io.*;
import java.util.*;

class StableMountains {
    public List<Integer> findIndices(int[] height, int threshold) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<height.length; i++) {
            if(height[i-1] > threshold) {
                ans.add(i);
            }
        }
        return ans;
    }
    
    public void display(List<Integer> ans) {
        if(ans.size()==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main (String[] args) {
        StableMountains mountains = new StableMountains();
        int[] height = {1,2,3,4,5};
        List<Integer> ans = mountains.findIndices(height, 2);
        mountains.display(ans);
        
        int[] height1 = {10,1,10,1,10};
        List<Integer> ans1 = mountains.findIndices(height1, 3);
        mountains.display(ans1);
        
        int[] height2 = {10,1,10,1,10};
        List<Integer> ans2 = mountains.findIndices(height2, 10);
        mountains.display(ans2);
    }
}