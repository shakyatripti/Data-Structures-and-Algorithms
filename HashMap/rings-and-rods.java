//Problem: https://leetcode.com/problems/rings-and-rods/description/





import java.io.*;
import java.util.*;

class RingsAndRods {
    public int countPoints(String rings) {
        int count  = 0;
        HashMap<Character, Set<Character>> mp = new HashMap<>();
        for(int i=0; i<rings.length()-1; i+=2) {
            char ch = rings.charAt(i+1);
            char ch1 = rings.charAt(i);
            if(mp.containsKey(ch)) {
                Set<Character> st = mp.get(ch);
                st.add(ch1);
                mp.put(ch, st);
            } else {
                Set<Character> st = new HashSet<>();
                st.add(ch1);
                mp.put(ch, st);
            }
        }

        for(Map.Entry<Character, Set<Character>> entry: mp.entrySet()) {
            Set<Character> st = entry.getValue();
            if(st.size()==3) {
               count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        RingsAndRods rings = new RingsAndRods();
        System.out.println(rings.countPoints("G3R3R7B7R5B1G8G4G7B3G6"));
        System.out.println(rings.countPoints("B0B6G0R6R0R6G9"));
        System.out.println(rings.countPoints("B0R0G0R9R0B0G0"));
        System.out.println(rings.countPoints("G5"));
    }
}