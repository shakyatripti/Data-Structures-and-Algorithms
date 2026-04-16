//Problem: https://leetcode.com/problems/pass-the-pillow/description/





import java.io.*;
import java.util.*;

class PassThePillow {
    public int findIndexOfPerson(int n, int time) {
        int start = 1;
        while(time > 0) {
            while(start!=n && time>0) {
                time--;
                start++;
            }
            while(start!=1 && time>0) {
                time--;
                start--;
            }
        }
        return start;
    }
}

class Main {
    public static void main(String[] args) {
        PassThePillow pillow = new PassThePillow();
        System.out.println(pillow.findIndexOfPerson(4, 5));
        System.out.println(pillow.findIndexOfPerson(3, 2));
        System.out.println(pillow.findIndexOfPerson(18, 38));
    }
}