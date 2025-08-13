//Problem: https://leetcode.com/problems/find-the-maximum-achievable-number/description/



import java.io.*;
import java.util.*;

class AchievableNumber {
    public int theMaximumX(int num, int t) {
        return num + 2*t;
    }
}

class Main {
    public static void main(String[] args) {
        AchievableNumber obj = new AchievableNumber();
        System.out.println(obj.theMaximumX(4,1));
        System.out.println(obj.theMaximumX(3,2));
    }
}