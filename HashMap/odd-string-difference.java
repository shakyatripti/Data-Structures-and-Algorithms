//Problem: https://leetcode.com/problems/odd-string-difference/description/




import java.io.*;
import java.util.*;

class OddStringDifference {
    public String findOdd(String[] words) {
        HashMap<String, ArrayList<String>> ans = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            String curr = "";
            for(int j=1; j<words[i].length(); j++) {
                int diff = (words[i].charAt(j)-'a') - (words[i].charAt(j-1)-'a');
                curr+=diff-'0';
            }
            if(ans.containsKey(curr)) {
                ArrayList<String> arr = ans.get(curr);
                arr.add(words[i]);
                ans.put(curr, arr);
            } else {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(words[i]);
                ans.put(curr, arr);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry: ans.entrySet()) {
            ArrayList<String> arr = entry.getValue();
            if(arr.size()==1) {
                return arr.get(0);
            }
        }
        return words[0];
    }
}

class Main {
    public static void main(String[] args) {
        OddStringDifference str = new OddStringDifference();
        String[] words = {"adc","wzy","abc"};
        System.out.println(str.findOdd(words));
        
        String[] words1 = {"aaa","bob","ccc","ddd"};
        System.out.println(str.findOdd(words1));
    }
}