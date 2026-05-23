//Problem: https://leetcode.com/problems/positions-of-large-groups/description/




import java.io.*;
import java.util.*;


class LargeGroups {
    public List<List<Integer>> findPositions(String s) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int start = i;
            while(i < s.length()-1 && ch==s.charAt(i+1)) {
                i++;
            }
            if((i-start+1)>=3) {
                ans.add(new ArrayList<>(Arrays.asList(start, i)));
            }
        }
        return ans;
    }
    
    public void display(List<List<Integer>> ans) {
        if(ans.size()==0) {
            System.out.println("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LargeGroups group = new LargeGroups();
        List<List<Integer>> ans = group.findPositions("abbxxxxzzy");
        group.display(ans);
        
        List<List<Integer>> ans1 = group.findPositions("abc");
        group.display(ans1);
        
        List<List<Integer>> ans2 = group.findPositions("abcdddeeeeaabbbcd");
        group.display(ans2);
    }
}