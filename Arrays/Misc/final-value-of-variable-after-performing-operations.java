//Problem: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description



import java.io.*;
import java.util.*;


class FinalValue {
    public int performOperations(String[] operations) {
        int val = 0;
        for(int i=0; i<operations.length; i++) {
            if(operations[i].equals("++X") || operations[i].equals("X++")) {
                val++;
            } else {
                val--;
            }
        }
        return val;
    }
}

class Main {
    public static void main(String[] args) {
        FinalValue val = new FinalValue();
        String[] operations = {"--X","X++","X++"};
        System.out.println(val.performOperations(operations));
        
        String[] operations1 = {"++X","++X","X++"};
        System.out.println(val.performOperations(operations1));
        
        String[] operations2 = {"X++","++X","--X","X--"};
        System.out.println(val.performOperations(operations2));
    }
}