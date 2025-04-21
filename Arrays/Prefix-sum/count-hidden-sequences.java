//Problem: https://leetcode.com/problems/count-the-hidden-sequences/description/



/*Problem Statement: We need to find how many sequences are possible such that nums[i+1]-nums[i] is equal to differences[i] 
    and lower<=nums[i]<=upper. Original nums array will have difference.length + 1 elements.

    Suppose difference array is [1,-3,4] then nums[1] - nums[0]=1, nums[2]-nums[1]=-3, nums[3]-nums[2]=4.
    We can now represent every nums[i] in form of nums[0]. Ex: nums[2] = -3 + (nums[1]) = -2 + nums[0].
    In generic terms, nums[i+1] = difference[i] + nums[i]. Now, we will find the range of sequence.
    min  + x >= lower and max + x <=upper where min and max are the minimum and maximum value of nums[i] in terms of x.
    Range of sequence = (lower - min, upper - max). Total elements possible in this range = (upper - max) - (lower - min) + 1;
*/


import java.io.*;
import java.util.*;

class HiddenSequences {
    public int countHiddenSequences(int[] differences, int lower, int upper) {
        long max=0, min=0, currSum=0;
        for(int i=0; i<differences.length; i++) {
            currSum+=differences[i];
            max = Math.max(currSum, max);
            min = Math.min(currSum, min);
        }
        long sequenceRange = (long) (upper-lower+1) - (max-min);
        return sequenceRange < 0 ? 0 : (int) sequenceRange;
    }
}

class Main {
    public static void main (String[] args) {
        HiddenSequences seq = new HiddenSequences();
        int[] differences = {1,-3,4};
        System.out.println(seq.countHiddenSequences(differences, 1, 6));
        
        int[] differences2 = {3,-4,5,1,-2};
        System.out.println(seq.countHiddenSequences(differences2, -4, 5));
        
        int[] differences3 = {4,-7,2};
        System.out.println(seq.countHiddenSequences(differences3, 3, 6));
    }
}