//Problem: https://leetcode.com/problems/reverse-prefix-of-word/description/




import java.io.*;
import java.util.*;


class PrefixOfWord {
    public String reverse(String word, char ch) {
        StringBuilder prefix = new StringBuilder("");
        int flag = 0;
        for(char ch1: word.toCharArray()) {
            prefix.append(ch1);
            if(ch1==ch && flag==0) {
                prefix.reverse();
                flag=1;
            }
        }
        return prefix.toString();
    }
}

class Main {
    public static void main(String[] args) {
        PrefixOfWord prefix = new PrefixOfWord();
        System.out.println(prefix.reverse("abcdefd", 'd'));
        System.out.println(prefix.reverse("xyxzxe", 'z'));
        System.out.println(prefix.reverse("abcd", 'z'));
    }
}