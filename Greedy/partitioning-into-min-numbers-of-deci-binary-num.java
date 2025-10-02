//Problem:  https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description




import java.io.*;
import java.util.*;


class DeciBinary {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(res, n.charAt(i) - '0');
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        DeciBinary num = new DeciBinary();
        System.out.println(num.minPartitions("32"));
        System.out.println(num.minPartitions("82734"));
        System.out.println(num.minPartitions("27346209830709182346"));
    }
}