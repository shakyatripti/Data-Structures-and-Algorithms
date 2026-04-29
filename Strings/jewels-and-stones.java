//Problem: https://leetcode.com/problems/jewels-and-stones/description/




import java.io.*;
import java.util.*;

class JewelsAndStones {
    public int count(String jewels, String stones) {
        int total = 0;
        for(int i=0; i<jewels.length(); i++) {
            for(int j=0; j<stones.length(); j++) {
                if(jewels.charAt(i)==stones.charAt(j)) {
                    total++;
                }
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        JewelsAndStones str = new JewelsAndStones();
        System.out.println(str.count("aA", "aAAbbbb"));
        System.out.println(str.count("z", "ZZ"));
    }
}