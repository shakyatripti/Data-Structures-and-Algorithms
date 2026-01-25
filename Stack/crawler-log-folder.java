//Problem: https://leetcode.com/problems/crawler-log-folder/description/




import java.io.*;
import java.util.*;

class LogFolder {
    public int minOperations(String[] logs) {
        int ops = 0;
        Stack<String> st = new Stack<>();
        for(int i=0; i<logs.length; i++) {
            if(logs[i].equals("../") && !st.isEmpty()) {
                st.pop();
            } else if(!logs[i].equals("../") && !logs[i].equals("./")) {
                st.push(logs[i]);
            }
        }

        while(!st.isEmpty()) {
            st.pop();
            ops++;
        }
        return ops;
    }
}

class Main {
    public static void main(String[] args) {
        LogFolder folder = new LogFolder();
        String[] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(folder.minOperations(logs));
        
        String[] logs1 = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println(folder.minOperations(logs1));
        
        String[] logs2 = {"d1/","../","../","../"};
        System.out.println(folder.minOperations(logs2));
        
        String[] logs3 = {"./","../","./"};
        System.out.println(folder.minOperations(logs3));
    }
}