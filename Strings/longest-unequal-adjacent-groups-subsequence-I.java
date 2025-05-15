//Problem: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/




import java.io.*;
import java.util.*;

class UnequalAdjacentGroups {
    public List<String> longestSubseq(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int i=0, flag=0;
        while(i < groups.length-1) {
            if(groups[i]!=groups[i+1]) {
                if(flag==0) {
                    result.add(words[i]);
                    flag=1;
                }
                result.add(words[i+1]);
            }
            i++;
        }
        
        if(result.size()==0) {
            result.add(words[0]);
        }
        
        return result;
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.print("\n");
    }
}


class Main {
    public static void main(String[] args) {
        UnequalAdjacentGroups subsequence = new UnequalAdjacentGroups();
        String[] words = {"e","a","b"};
        int[] groups = {0,0,1};
        List<String> ans = subsequence.longestSubseq(words, groups);
        subsequence.display(ans);
        
        String[] words1 = {"d"};
        int[] groups1 = {1};
        List<String> ans1 = subsequence.longestSubseq(words1, groups1);
        subsequence.display(ans1);
        
        String[] words2 = {"lr", "h"};
        int[] groups2 = {1,1,1};
        List<String> ans2 = subsequence.longestSubseq(words2, groups2);
        subsequence.display(ans2);
        
        String[] words3 = {"a","b","c","d"};
        int[] groups3 = {1,0,1,1};
        List<String> ans3 = subsequence.longestSubseq(words3, groups3);
        subsequence.display(ans3);
    }
}