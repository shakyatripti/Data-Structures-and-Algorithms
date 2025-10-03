//Problem: https://leetcode.com/problems/restore-finishing-order/description/



import java.io.*;
import java.util.*;


class RestoreFinishingOrder {
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] ans = new int[friends.length];
        int[] friendsFreq = new int[101];
        for(int i=0; i<friends.length; i++) {
            friendsFreq[friends[i]]++;
        }
        int k=0;
        for(int i=0; i<order.length; i++) {
            if(friendsFreq[order[i]] > 0) {
                ans[k] = order[i];
                k++;
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
        RestoreFinishingOrder arr = new RestoreFinishingOrder();
        int[] order = {3,1,2,5,4};
        int[] friends = {1,3,4};
        int[] ans = arr.recoverOrder(order, friends);
        arr.display(ans);
        
        int[] order1 = {1,4,5,3,2};
        int[] friends1 = {3,5};
        int[] ans1 = arr.recoverOrder(order1, friends1);
        arr.display(ans1);
    }
}