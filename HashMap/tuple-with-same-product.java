//Problem: https://leetcode.com/problems/tuple-with-same-product/description/

import java.io.*;
import java.util.*;

class TupleWithSameProduct {
    public int countTuples(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> products = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int prod = nums[i]*nums[j];
                if(products.containsKey(prod)) {
                    products.put(prod, products.get(prod) + 1);
                    count+=8*products.get(prod);
                } else {
                    products.put(prod,0);
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,12,10,20,30,40,50,54};
        int[] nums1 = {2,3,4,6};
        TupleWithSameProduct tuples = new TupleWithSameProduct();
        System.out.println(tuples.countTuples(nums));
        System.out.println(tuples.countTuples(nums1));
    }
}