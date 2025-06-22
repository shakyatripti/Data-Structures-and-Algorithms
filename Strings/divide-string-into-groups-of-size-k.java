//Problem: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/




import java.io.*;
import java.util.*;

class DivideStringIntoGroups {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder str = new StringBuilder(s);
        while(str.length()%k!=0) {
            str.append(fill);
        }
        String[] ans= new String[str.length()/k];
        for(int i=0; i<str.length()/k; i++) {
            ans[i] = str.substring(i*k, (i*k)+k);
        }
        return ans;
    }
    
    public void display(String[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DivideStringIntoGroups groups = new DivideStringIntoGroups();
        String[] ans = groups.divideString("abcdefghi", 3, 'x');
        groups.display(ans);
        
        String[] ans1 = groups.divideString("abcdefghij", 3, 'y');
        groups.display(ans1);
    }
}