//Problem: https://leetcode.com/problems/find-common-characters/description/





import java.io.*;
import java.util.*;

class CommonCharacters {
    public List<String> findCommon(String[] words) {
        int[] freq = new int[26];
        for(int i=0; i<words[0].length(); i++) {
            int ch = words[0].charAt(i) - 'a';
            freq[ch]++;
        }
        for(int i=1; i<words.length; i++) {
            int[] temp = new int[26];
            for(char ch: words[i].toCharArray()) {
                temp[ch-'a']++;
            }
            for(int j=0; j<26; j++) {
                freq[j] = Math.min(freq[j], temp[j]);
            }
        }
        List<String> ans = new ArrayList<String>();
        for(int i=0; i<26; i++) {
            if(freq[i]>0) {
                for(int k=0; k<freq[i]; k++) {
                    char ch = (char) (i + 'a');
                    ans.add(String.valueOf(ch));
                }
            }
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
        CommonCharacters str = new CommonCharacters();
        String[] words = {"bella","label","roller"};
        List<String> ans = str.findCommon(words);
        str.display(ans);
        
        String[] words1 = {"cool","lock","cook"};
        List<String> ans1 = str.findCommon(words1);
        str.display(ans1);
    }
}
