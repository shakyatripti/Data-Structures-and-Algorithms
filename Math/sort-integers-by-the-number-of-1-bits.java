//Problem: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/




import java.io.*;
import java.util.*;

class NumberOfOneBits {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        Set<Integer> num = new HashSet<>();
        int[] res = new int[arr.length];
        int k=0;
        for(int i=0; i<arr.length; i++) {
            int ones = countOnes(arr[i]);
            if(mp.containsKey(ones)) {
                ArrayList<Integer> ans = mp.get(ones);
                ans.add(arr[i]);
                mp.put(ones, ans);
            } else {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(arr[i]);
                mp.put(ones, ans);
            }
            num.add(ones);
        }

        Iterator it = num.iterator();
        while(it.hasNext()) {
            int val = (int) it.next();
            ArrayList<Integer> ans = mp.get(val);
            Collections.sort(ans);
            for(int i=0; i<ans.size(); i++) {
                res[k] = ans.get(i);
                k++;
            }
        }
        return res;
    }

    public int countOnes(int n) {
        int ans = 0;
        while(n!=0) {
            int r = n%2;
            if(r==1) {
                ans++;
            }
            n=n/2;
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
        NumberOfOneBits bit = new NumberOfOneBits();
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] ans = bit.sortByBits(arr);
        bit.display(ans);
        
        int[] arr1 = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] ans1 = bit.sortByBits(arr1);
        bit.display(ans1);
    }
}