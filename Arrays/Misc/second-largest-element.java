//Problem: https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest

//1st Solution: Better Solution
public int getSecondLargest(int[] arr) {
        // Code Here
       int max1 = Integer.MIN_VALUE, max2 = -1;
       for(int i=0; i<arr.length; i++) {
        	if(arr[i] >= max1) {
	            max1= arr[i];
	        }
       }
       for(int i=0; i<arr.length; i++) {
           if(arr[i]!=max1 && arr[i]>max2) {
               max2 = arr[i];
           }
       }
       return max2;
}

//2nd Solution: Optimal Solution
public int getSecondLargest(int[] arr) {
    int large=-1, sec_large=-1;
    for(int i=0; i<arr.length; i++) {
        if(arr[i] > large) {
            sec_large = large;      
            large = arr[i];
        } else if(arr[i] > sec_large && arr[i]!=large) {
            sec_large = arr[i];
        }
    }
    return sec_large;
}
