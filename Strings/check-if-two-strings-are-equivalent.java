
//Problem: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/



import java.io.*;
import java.util.*;

class ArrayStrings {

    public boolean areEqual(String[] word1, String[] word2) {
        String s1 = formWord(word1);
        String s2 = formWord(word2);

        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }

    public String formWord(String[] arr) {
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {

        ArrayStrings str = new ArrayStrings();
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(str.areEqual(word1, word2));

        String[] word3 = {"a", "cb"};
        String[] word4 = {"ab", "c"};
        System.out.println(str.areEqual(word3, word4));

        String[] word5 = {"abc", "d", "defg"};
        String[] word6 = {"abcddefg"};
        System.out.println(str.areEqual(word5, word6));
    }
}