//Problem: https://leetcode.com/problems/shuffle-string/description/




import java.io.*;
import java.util.*;


class ShuffleString {
    public String restoreString(String s, int[] indices) {
        HashMap<Integer, Character> mp = new HashMap<>();
        String ans = "";
        int n=indices.length;
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            mp.put(indices[i], ch);
        }

        for(int i=0; i<n; i++) {
            ans+=mp.get(i);
        }

        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ShuffleString str = new ShuffleString();
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(str.restoreString("codeleet", indices));
        
        int[] indices1 = {0,1,2};
        System.out.println(str.restoreString("abc", indices1));
    }
}