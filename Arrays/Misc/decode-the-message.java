//Problem: https://leetcode.com/problems/decode-the-message/description/



import java.io.*;
import java.util.*;

class DecodeTheMessage {
    public String decode(String key, String message) {
        HashMap<Character, Character> mp = new HashMap<>();
        char chr = 'a';
        for(char ch: key.toCharArray()) {
            if(ch!=' ' && !mp.containsKey(ch)) {
                mp.put(ch, chr);
                chr++;
            }
        }

        String ans="";
        for(char ch: message.toCharArray()) {
            if(ch==' ') {
                ans+= " ";
            } else {
                ans+=mp.get(ch);
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        DecodeTheMessage message = new DecodeTheMessage();
        System.out.println(message.decode("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        
        System.out.println(message.decode("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}