//Problem: https://leetcode.com/problems/add-two-integers/description/




import java.io.*;
import java.util.*;

class AddIntegers {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}

class Main {
    public static void main(String[] args) {
        AddIntegers obj = new AddIntegers();
        System.out.println(obj.sum(12, 5));
        System.out.println(obj.sum(-10, 4));
    }
}