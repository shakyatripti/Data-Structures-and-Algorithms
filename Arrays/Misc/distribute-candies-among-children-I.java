//Problem: https://leetcode.com/problems/distribute-candies-among-children-i/description/





import java.io.*;
import java.util.*;

class CandiesAmongChildrenI {
    public int distribute(int n, int limit) {
        int count = 0;
        for(int i=0; i<=limit; i++) {
            for(int j=0; j<=limit; j++) {
                for(int k=0; k<=limit; k++) {
                    if((i+j+k)==n) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CandiesAmongChildrenI children = new CandiesAmongChildrenI();
        System.out.println(children.distribute(5, 2));
        System.out.println(children.distribute(3, 3));
    }
}