//Problem: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description





import java.io.*;
import java.util.*;

class CommonArray {
    public int[] findThePrefix(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Set<Integer> arr = new HashSet<>();
        for(int i=0; i<A.length; i++) {
            arr.add(A[i]);
            arr.add(B[i]);
            if(arr.size()!=(2*(i+1))) {
                ans[i]=2*(i+1) - arr.size();
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        CommonArray arr = new CommonArray();
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[] ans = arr.findThePrefix(A, B);
        arr.display(ans);
        
        int[] A1 = {2,3,1};
        int[] B1 = {3,1,2};
        int[] ans1 = arr.findThePrefix(A1, B1);
        arr.display(ans1);
    }
}