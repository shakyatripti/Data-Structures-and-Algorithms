//Problem: https://leetcode.com/problems/partition-string/description/




import java.io.*;
import java.util.*;

class PartitionString {
    public List<String> segments(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> segments = new HashMap<>();
        int index=0;
        StringBuilder curr = new StringBuilder();
        while(s.length() > index) {
            curr.append(s.charAt(index)); 
            String res = curr.toString();
            if(!segments.containsKey(res)) {
                ans.add(res);
                segments.put(res, 1);
                curr=new StringBuilder();
            }
            index++;
        }
        return ans;
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        PartitionString str = new PartitionString();
        List<String> ans = str.segments("abbccccd");
        str.display(ans);
        
        List<String> ans1 = str.segments("aaaa");
        str.display(ans1);
    }
}