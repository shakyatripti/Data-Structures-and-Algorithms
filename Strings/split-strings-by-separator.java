//Problem: https://leetcode.com/problems/split-strings-by-separator/description/




import java.io.*;
import java.util.*;


class SplitWords {
    public List<String> splitBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        String s = String.valueOf(separator);
        for(int i=0; i<words.size(); i++) {
            String[] res = words.get(i).split("\\" + s);
            for(int j=0; j<res.length; j++) {
                if(res[j].length()!=0) {
                    ans.add(res[j]);
                }
            }
        }
        return ans;
    }
    
    public void display(List<String> ans) {
        if(ans.size()==0) {
            System.out.print("--");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SplitWords str = new SplitWords();
        List<String> words = new ArrayList<>(Arrays.asList("one.two.three","four.five","six"));
        List<String> ans = str.splitBySeparator(words, '.');
        str.display(ans);
        
        List<String> words1 = new ArrayList<>(Arrays.asList("$easy$","$problem$"));
        List<String> ans1 = str.splitBySeparator(words1, '$');
        str.display(ans1);
        
        List<String> words2 = new ArrayList<>(Arrays.asList("|||"));
        List<String> ans2 = str.splitBySeparator(words2, '|');
        str.display(ans2);
    }
}