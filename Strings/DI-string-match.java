//Problem: https://leetcode.com/problems/di-string-match/description/




import java.io.*;
import java.util.*;

class DIStringMatch {
    public int[] matching(String s) {
        int[] perm = new int[s.length() + 1];
        int m=0, n=s.length();
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='I') {
                perm[i]=m;
                m++;
            } else {
                perm[i]=n;
                n--;
            }
        }
        perm[s.length()] = m;
        return perm;
    }
    
    public void display(int[] perm) {
        for(int i=0; i<perm.length; i++) {
            System.out.print(perm[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DIStringMatch str = new DIStringMatch();
        int[] perm1 = str.matching("IDID");
        str.display(perm1);
        
        int[] perm2 = str.matching("III");
        str.display(perm2);
        
        int[] perm3 = str.matching("DDI");
        str.display(perm3);
    }
}