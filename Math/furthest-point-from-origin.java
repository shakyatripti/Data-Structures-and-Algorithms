//Problem: https://leetcode.com/problems/furthest-point-from-origin/description/





import java.io.*;
import java.util.*;

class FurthestPointFromOrigin {
    public int calcDistance(String moves) {
        int lefts=0, rights=0, empty=0, steps=0;
        for(char ch: moves.toCharArray()) {
            if(ch=='L') {
                lefts++;
            } else if(ch=='R') {
                rights++;
            } else {
                empty++;
            }
        }

        if(lefts > rights) {
            steps = rights - empty - lefts;
        } else {
            steps = rights + empty - lefts;
        }

        return Math.abs(steps);
    }
}



class Main {
    public static void main(String[] args) {
        FurthestPointFromOrigin point = new FurthestPointFromOrigin();
        System.out.println(point.calcDistance("L_RL__R"));
        System.out.println(point.calcDistance("_R__LL_"));
        System.out.println(point.calcDistance("_______"));
        System.out.println(point.calcDistance("_R"));
    }
}