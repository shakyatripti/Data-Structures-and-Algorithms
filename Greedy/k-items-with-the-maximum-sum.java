//Problem: https://leetcode.com/problems/k-items-with-the-maximum-sum/description/





import java.io.*;
import java.util.*;

class KItems {
    public int maximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        while(numOnes!=0) {
            arr.add(1);
            numOnes--;
        }
        while(numZeros!=0) {
            arr.add(0);
            numZeros--;
        }
        while(numNegOnes!=0) {
            arr.add(-1);
            numNegOnes--;
        }
        for(int i=0; i<k; i++) {
            sum+=arr.get(i);
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        KItems items = new KItems();
        System.out.println(items.maximumSum(3,2,0,2));
        System.out.println(items.maximumSum(3,2,0,4));
        System.out.println(items.maximumSum(6,6,6,13));
    }
}