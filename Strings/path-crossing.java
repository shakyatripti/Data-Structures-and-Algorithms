//Problem: https://leetcode.com/problems/path-crossing/description/




import java.io.*;
import java.util.*;

class PathCrossing {
    public boolean isCrossing(String path) {
        ArrayList<String> st = new ArrayList<>();
        int x=0, y=0;
        st.add("0 0");
        for(char ch: path.toCharArray()) {
            if(ch=='N') {
                y++;
            } else if(ch=='E') {
                x++;
            } else if(ch=='S') {
                y--;
            } else {
                x--;
            }
            String ch1 = String.valueOf(x);
            String ch2 = String.valueOf(y);
            String dir = ch1 + " " + ch2;
            if(st.contains(dir)) {
                return true;
            }
            st.add(dir);
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        PathCrossing directions = new PathCrossing();
        System.out.println(directions.isCrossing("NES"));
        System.out.println(directions.isCrossing("NESWW"));
        System.out.println(directions.isCrossing("ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS"));
    }
}