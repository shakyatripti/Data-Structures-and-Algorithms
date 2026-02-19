//Problem: https://leetcode.com/problems/binary-watch/description/




import java.io.*;
import java.util.*;

class BinaryWatch {
    public List<String> read(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<=11; i++) {
            for(int j=0; j<=59; j++) {
                if((countBits(i) + countBits(j)) == turnedOn) {
                    String hour = String.valueOf(i);
                    String min = "";
                    if(j <= 9) {
                        min="0" + j;
                    } else {
                        min = String.valueOf(j);
                    }
                    ans.add(hour + ":" + min);
                }
            }
        }
        return ans;
    }

    public int countBits(int n) {
        int count = 0;
        while(n!=0) {
            int r = n%2;
            if(r==1) {
                count++;
            }
            n=n/2;
        }
        return count;
    }
    
    public void display(List<String> ans) {
        if(ans.size()==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        BinaryWatch watch = new BinaryWatch();
        List<String> ans = watch.read(1);
        watch.display(ans);
        
        List<String> ans1 = watch.read(9);
        watch.display(ans1);
    }
}