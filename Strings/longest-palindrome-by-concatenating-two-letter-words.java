//Problem: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/



/*Problem Statement: Given array of strings of length two, we need to find longest palindrome possible after concatenating the words from
    the array. We first iterate the array to find if reverse of the word is there in the array or not. If reversed word is present it sums up the length by 4.
    At the end, we need to find such word whose first and second letter is same, so that we can put that word in the middle of the palindrome.

    Ex: {lc, cl, gg, bb} , we first iterate "lc" and its reverse is "cl", but now in map we do not have any key as "cl", so we simply add and increase
    frequency of "lc". In second iteration we get "cl" and its reverse is "lc". In map also we have "lc" with frequency > 0. So current palindrome can be "cllc" with 
    total length as 4. In third iteration we get "gg" and its reverse is "gg" itself. The reverse form is not present in map, so we simply add and increase the frequency
    of "gg". Fourth iteration will run same as third iteration. Now after exiting first loop, we go to last loop to find the words with same letter, so that we can add 
    it in the middle of the palindrome. So final palindrome will look like "clgglc" with length as 6.

    Note: We can add only single same letter word in the middle to form the palindrome.
*/




import java.io.*;
import java.util.*;

class LongestPalindrome {
    public int concatenateLetters(String[] words) {
        int len = 0;
        int[][] freq = new int[26][26];
        for(int i=0; i<words.length; i++) {
            int firstIndex = words[i].charAt(0) - 'a';
            int secondIndex = words[i].charAt(1) - 'a';
            if(freq[secondIndex][firstIndex] > 0) {
                len+=4;
                freq[secondIndex][firstIndex]--;
            } else {
                freq[firstIndex][secondIndex]++;
            }
        }
        
        for(int i=0; i<words.length; i++) {
            int firstIndex = words[i].charAt(0) - 'a';
            int secondIndex = words[i].charAt(1) - 'a';
            if(firstIndex==secondIndex && freq[firstIndex][secondIndex] > 0) {
                len+=2;
                break;
            }
        }
        return len;
    }
}

class Main {
    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String[] words = {"lc","cl","gg"};
        System.out.println(palindrome.concatenateLetters(words));
        
        String[] words1 = {"ab","ty","yt","lc","cl","ab"};
        System.out.println(palindrome.concatenateLetters(words1));
        
        String[] words2 = {"cc","ll","xx"};
        System.out.println(palindrome.concatenateLetters(words2));
        
        String[] words3 = {"bb","bb"};
        System.out.println(palindrome.concatenateLetters(words3));
        
        String[] words4 = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        System.out.println(palindrome.concatenateLetters(words4));
    }
}