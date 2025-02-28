//Problem: https://leetcode.com/problems/shortest-common-supersequence/description/



//Tabulation Approach
import java.io.*;
import java.util.*;

class ShortestCommonSeq {
    public String shortestCommonSequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=m; i++) {
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int maxlen = dp[n][m];
        int ind1=n, ind2=m, index = maxlen-1;
        String ans = "";
        while(ind1 > 0 && ind2 > 0) {
            if(str1.charAt(ind1-1)==str2.charAt(ind2-1)) {
                ans+=str1.charAt(ind1-1);
                ind1--;
                ind2--;
                index--;
            } else if(dp[ind1-1][ind2] > dp[ind1][ind2-1]) {
                ans+=str1.charAt(ind1-1);
                ind1--;
            } else {
                ans+=str2.charAt(ind2-1);
                ind2--;
            }
        }
        
        while(ind1 > 0) {
            ans+=str1.charAt(ind1-1);
            ind1--;
        }
        
        while(ind2 > 0) {
            ans+=str2.charAt(ind2-1);
            ind2--;
        }
        
        String res = new StringBuilder(ans).reverse().toString();
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        ShortestCommonSeq seq = new ShortestCommonSeq();
        System.out.println(seq.shortestCommonSequence("abac", "cab"));
        System.out.println(seq.shortestCommonSequence("abdefmn", "dmon"));
    }
}