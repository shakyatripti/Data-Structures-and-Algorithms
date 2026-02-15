//Problem: https://leetcode.com/problems/add-binary/description/





import java.io.*;
import java.util.*;

class BinaryString {
    public String addTwoBinary(String a, String b) {
        StringBuilder str = new StringBuilder("");
        int carry=0;
        int i = a.length()-1;
        int j = b.length()-1;
        while(i>=0 || j>=0 || carry==1) {
            int sum = carry;
            if(i>=0) {
                sum+=a.charAt(i) - '0';
                i--;
            }
            if(j>=0) {
                sum+=b.charAt(j) - '0';
                j--;
            }
            str.append(sum%2);
            carry=sum/2;
        }
        return str.reverse().toString();
    }
}

class Main {
    public static void main(String[] args) {
        BinaryString str = new BinaryString();
        System.out.println(str.addTwoBinary("11", "1"));
        System.out.println(str.addTwoBinary("0", "0"));
        System.out.println(str.addTwoBinary("0", "1"));
        System.out.println(str.addTwoBinary("1010", "1011"));
        System.out.println(str.addTwoBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}