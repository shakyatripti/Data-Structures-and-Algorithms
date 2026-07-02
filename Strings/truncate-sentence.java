//Problem: https://leetcode.com/problems/truncate-sentence/description/



import java.io.*;
import java.util.*;


class Sentence {
    public String truncate(String s, int k) {
        String ans = "";
        String[] words = s.split("\\ ");
        for(int i=0; i<k; i++) {
            ans+=words[i];
            if(i!=k-1) {
                ans+=" ";
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Sentence str = new Sentence();
        System.out.println(str.truncate("Hello how are you Contestant", 4));
        System.out.println(str.truncate("What is the solution to this problem", 4));
        System.out.println(str.truncate("chopper is not a tanuki", 5));
    }
}