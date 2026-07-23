//Problem: https://leetcode.com/problems/uncommon-words-from-two-sentences/description/




import java.io.*;
import java.util.*;

class Sentences {
    public String[] uncommonWords(String s1, String s2) {
        HashMap<String, Integer> mp1 = new HashMap<>();
        HashMap<String, Integer> mp2 = new HashMap<>();
        String[] str1 = s1.split("\\ ");
        String[] str2 = s2.split("\\ ");
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<str1.length; i++) {
            mp1.put(str1[i], mp1.getOrDefault(str1[i], 0) + 1);
        }

        for(int i=0; i<str2.length; i++) {
            mp2.put(str2[i], mp2.getOrDefault(str2[i], 0) + 1);
        }

        for(int i=0; i<str1.length; i++) {
            int val = mp1.get(str1[i]);
            if(val==1 && !mp2.containsKey(str1[i])) {
                ans.add(str1[i]);
            }
        }

        for(int i=0; i<str2.length; i++) {
            int val = mp2.get(str2[i]);
            if(val==1 && !mp1.containsKey(str2[i])) {
                ans.add(str2[i]);
            }
        }

        String[] res = new String[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    
    public static void display(String[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Sentences st = new Sentences();
        String[] ans = st.uncommonWords("this apple is sweet", "this apple is sour");
        st.display(ans);
        
        String[] ans1 = st.uncommonWords("apple apple", "banana");
        st.display(ans1);
    }
}