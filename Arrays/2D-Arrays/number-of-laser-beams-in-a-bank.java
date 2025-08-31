//Problem: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/





import java.io.*;
import java.util.*;

class LaserBeamsInBank {
    public int numberOfBeams(String[] bank) {
        ArrayList<Integer> beams = new ArrayList<>();
        for(int i=0; i<bank.length; i++) {
            int lasers = 0;
            for(char ch: bank[i].toCharArray()) {
                if(ch=='1') {
                    lasers++;
                }
            }
            if(lasers!=0) {
                beams.add(lasers);
            }
        }
        if(beams.size() <=1 ) {
            return 0;
        }
        int total = 0;
        for(int i=0; i<beams.size()-1; i++) {
            int val = beams.get(i)*beams.get(i+1);
            total+=val;
        }
        return total;
    } 
}


class Main {
    public static void main(String[] args) {
        LaserBeamsInBank device = new LaserBeamsInBank();
        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(device.numberOfBeams(bank));
        
        String[] bank1 = {"000","111","000"};
        System.out.println(device.numberOfBeams(bank1));
    }
}