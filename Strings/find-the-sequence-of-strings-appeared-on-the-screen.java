//Problem: https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/




import java.io.*;
import java.util.*;

class SequenceOfStrings {
    public List<String> appearedOnScreen(String target) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        String curr= "",prev="";
        while(target.length() > index) {
            curr+=target.charAt(index);
            for(char ch='a'; ch<='z'; ch++) {
                String str = prev;
                str+=ch;
                ans.add(str);
                if(curr.charAt(curr.length()-1)==ch) {
                    break;
                }
            }
            index++;
            prev=curr;
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
        SequenceOfStrings str = new SequenceOfStrings();
        List<String> ans = str.appearedOnScreen("abc");
        str.display(ans);
        
        List<String> ans1 = str.appearedOnScreen("he");
        str.display(ans1);
    }
}