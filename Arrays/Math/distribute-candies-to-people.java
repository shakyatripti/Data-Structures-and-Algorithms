//Problem: https://leetcode.com/problems/distribute-candies-to-people/description/





import java.io.*;
import java.util.*;

class CandiesDistribution {
    public int[] distributeAmongPeople(int candies, int num_people) {
        int[] ans = new int[num_people];
        int k=1, i=0;
        while(candies > 0) {
            candies-=k;
            if(candies < 0) {
                k+=candies;
            }
            ans[i%num_people]+=k;
            k++;
            i++;
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
        CandiesDistribution candies = new CandiesDistribution();
        int[] ans = candies.distributeAmongPeople(7,4);
        candies.display(ans);
        
        int[] ans1 = candies.distributeAmongPeople(10,3);
        candies.display(ans1);
        
        int[] ans2 = candies.distributeAmongPeople(60,4);
        candies.display(ans2);
    }
}