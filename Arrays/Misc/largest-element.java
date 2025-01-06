//Problem: https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array

class Solution {
    public static int largest(int[] arr) {
       int max=Integer.MIN_VALUE;
       for(int i=0; i<arr.length;i++) {
            if(arr[i] > max) {
                 max = arr[i];
           	}
       }
       return max;
    }
}
