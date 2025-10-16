//Problem: https://leetcode.com/problems/compute-decimal-representation/description/




import java.io.*;
import java.util.*;

class DecimalRepresentation {
    public int[] compute(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int pow = 0, index = 0;
        while(n!=0) {
            int r = n%10;
            n=n/10;
            if(r!=0) {
                int num = (int) r *  (int) Math.pow(10, pow);
                arr.add(num);
            }
            pow++;
        }
        int[] ans = new int[arr.size()];
        Collections.sort(arr);
        for(int i=arr.size()-1; i>=0; i--){
            ans[index] = arr.get(i);
            index++;
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
        DecimalRepresentation num = new DecimalRepresentation();
        int[] ans = num.compute(537);
        num.display(ans);
        
        int[] ans1 = num.compute(102);
        num.display(ans1);
        
        int[] ans2 = num.compute(6);
        num.display(ans2);
    }
}