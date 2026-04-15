//Problem: https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/




import java.io.*;
import java.util.*;

class CircularArray {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length, curr = (startIndex  - 1 + n) % n, prevCount = 0, nextCount=0;
        if(words[startIndex].equals(target)) {
            return 0;
        }
        while(curr!=startIndex) {
            prevCount++;
            if(words[curr].equals(target)) {
                break;
            }
            curr = (curr - 1 + n) % n;
        }

        curr = (startIndex + 1) % n;
        while(curr!=startIndex) {
            nextCount++;
            if(words[curr].equals(target)) {
                break;
            }
            curr = (curr + 1) % n;
        }
        if(prevCount==n-1 && nextCount==n-1) {
            return -1;
        }
        return Math.min(prevCount, nextCount);
    }
}

class Main {
    public static void main(String[] args) {
        CircularArray arr = new CircularArray();
        String[] words = {"hello","i","am","leetcode","hello"};
        System.out.println(arr.closestTarget(words, "hello", 1));
        
        String[] words1 = {"a","b","leetcode"};
        System.out.println(arr.closestTarget(words1, "leetcode", 0));
        
        String[] words2 = {"i","eat","leetcode"};
        System.out.println(arr.closestTarget(words2, "ate", 0));
        
        String[] words3 = {"pgmiltbptl","jnkxwutznb","bmeirwjars","ugzyaufzzp","pgmiltbptl","sfhtxkmzwn","pgmiltbptl",
        "pgmiltbptl","onvmgvjhxa","jyzdtwbwqp"};
        System.out.println(arr.closestTarget(words3, "pgmiltbptl", 4));
        
        String[] words4 = {"hqrdflmsiv","bphfkwxwux","jwhovjrktk","masvwbrofg","bpngempqkt","bphfkwxwux","bpngempqkt",
        "wvpoegifyu","bpngempqkt","wrgdcgwvrx"};
        System.out.println(arr.closestTarget(words4, "bpngempqkt", 1));
    }
}