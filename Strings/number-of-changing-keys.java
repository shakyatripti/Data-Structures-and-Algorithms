//Problem: https://leetcode.com/problems/number-of-changing-keys/description/




import java.io.*;
import java.util.*;

class ChangingKeys {
    public int countKeyChanges(String s) {
        String str = s.toLowerCase();
        int ans = 0;
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i)!=str.charAt(i+1)) {
                ans++;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ChangingKeys str = new ChangingKeys();
        System.out.println(str.countKeyChanges("aAbBcC"));
        System.out.println(str.countKeyChanges("AaAaAaaA"));
    }
}