//Problem: https://leetcode.com/problems/number-of-prefix-connected-groups/description/





import java.io.*;
import java.util.*;

class PrefixConnected {
    public int countGroups(String[] words, int k) {
        int ans = 0;
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            if(k <= words[i].length()) {
                String str = words[i].substring(0, k);
                mp.put(str, mp.getOrDefault(str, 0) + 1);  
            }
        }

        for(Map.Entry<String, Integer> it: mp.entrySet()) {
            String key = it.getKey();
            int groups = it.getValue();
            if(groups >= 2) {
               ans++; 
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        PrefixConnected str = new PrefixConnected();
        String[] words = {"apple","apply","banana","bandit"};
        System.out.println(str.countGroups(words, 2));
        
        String[] words1 = {"car","cat","cartoon"};
        System.out.println(str.countGroups(words1, 3));
        
        String[] words2 = {"bat","dog","dog","doggy","bat"};
        System.out.println(str.countGroups(words2, 3));
    }
}