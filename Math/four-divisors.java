//Problem: https://leetcode.com/problems/four-divisors/description/




//Brute-force solution
import java.io.*;
import java.util.*;

class FourDivisors {
    public int findSum(int[] nums) {
        int ans = 0;
        HashMap<Integer, Set<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int arr = (int) Math.sqrt(nums[i]);
            Set<Integer> st = new HashSet<>();
            if(!mp.containsKey(nums[i])) {
                for(int j=1; j<=arr; j++) {
                    if(nums[i]%j==0) {
                        st.add(j);
                        st.add(nums[i]/j);
                    }
                }
                mp.put(nums[i], st);
            }
        }

        for(int j=0; j<nums.length; j++) {
            Set<Integer> arr = mp.get(nums[j]);
            if(arr.size()==4) {
                Iterator it = arr.iterator();
                while(it.hasNext()) {
                    ans+=(int) it.next();
                }
            }
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        FourDivisors div = new FourDivisors();
        int[] nums = {21,4,7};
        System.out.println(div.findSum(nums));
        
        int[] nums1 = {21,21};
        System.out.println(div.findSum(nums1));
        
        int[] nums2 = {1,2,3,4,5};
        System.out.println(div.findSum(nums2));
        
        int[] nums3 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(div.findSum(nums3));
    }
}





//Optimal solution
import java.io.*;
import java.util.*;

class FourDivisors {
    public int findSum(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            int n=(int) Math.sqrt(nums[i]);
            int count = 0, sum = 0;
            for(int j=1; j<=n; j++) {
                if(nums[i]%j==0) {
                    count++;
                    sum+=j;
                    if(j!=nums[i]/j) {
                        count++;
                        sum+=nums[i]/j;
                    }
                }

                if(count > 4) {
                    break;
                }
            }
            if(count==4) {
                ans+=sum;
            }
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        FourDivisors div = new FourDivisors();
        int[] nums = {21,4,7};
        System.out.println(div.findSum(nums));
        
        int[] nums1 = {21,21};
        System.out.println(div.findSum(nums1));
        
        int[] nums2 = {1,2,3,4,5};
        System.out.println(div.findSum(nums2));
        
        int[] nums3 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(div.findSum(nums3));
    }
}