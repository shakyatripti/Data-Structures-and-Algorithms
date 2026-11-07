//Problem: https://leetcode.com/problems/ransom-note/description/





import java.io.*;
import java.util.*;

class RansomNoteConstruction {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        int[] freq1 = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            freq[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            freq1[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] < freq[i]) {
                return false;
            }
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        RansomNoteConstruction ransomNote = new RansomNoteConstruction();

        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
    }
}
