//Problem: https://leetcode.com/problems/delete-columns-to-make-sorted/description/





import java.io.*;
import java.util.*;

class MakeSorted {
    public int deleteColumns(String[] strs) {
        int count = 0;
        for(int i=0; i<strs[0].length(); i++) {
            for(int j=0; j<strs.length-1; j++) {
                int ch1 = strs[j].charAt(i) -'a';
                int ch2 = strs[j+1].charAt(i) -'a';
                if(ch1 > ch2) {
                    count++;
                    break;
                }        
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MakeSorted arr = new MakeSorted();
        String[] strs = {"cba","daf","ghi"};
        System.out.println(arr.deleteColumns(strs));
        
        String[] strs1 = {"a","b"};
        System.out.println(arr.deleteColumns(strs1));
        
        String[] strs2 = {"zyx","wvu","tsr"};
        System.out.println(arr.deleteColumns(strs2));
    }
}