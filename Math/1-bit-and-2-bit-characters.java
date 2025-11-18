//Problem: https://leetcode.com/problems/1-bit-and-2-bit-characters/description/




import java.io.*;
import java.util.*;

class SpecialCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        for(i=0; i<bits.length-1; i++) {
            if(bits[i]==1) {
                i++;
            }
        }
        if(i < bits.length && bits[i]==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialCharacters num = new SpecialCharacters();
        int[] bits = {1,1,0};
        System.out.println(num.isOneBitCharacter(bits));
        
        int[] bits1 = {1,1,1,0};
        System.out.println(num.isOneBitCharacter(bits1));
    }
}