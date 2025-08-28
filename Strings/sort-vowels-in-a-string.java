//Problem: https://leetcode.com/problems/sort-vowels-in-a-string/description/




import java.io.*;
import java.util.*;

class SortVowels {
    public String sorting(String s) {
        int k=0;
        StringBuilder ans = new StringBuilder();
        ArrayList<Character> str = new ArrayList<>();
        for(char ch: s.toCharArray()) {
            if(ch=='a' || ch=='e' || ch=='o' || ch=='u' || ch=='i' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='A') {
                str.add(ch);
            }
        }

        Collections.sort(str);

        for(char ch: s.toCharArray()) {
            char ch1 = Character.toLowerCase(ch);
            if(ch1=='a' || ch1=='e' || ch1=='o' || ch1=='u' || ch1=='i') {
                ans.append(str.get(k));
                k++;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}


class Main {
    public static void main(String[] args) {
        SortVowels str = new SortVowels();
        System.out.println(str.sorting("lEetcOde"));
        System.out.println(str.sorting("lYmpH"));
    }
}