//Problem: https://leetcode.com/problems/defanging-an-ip-address/description/




import java.io.*;
import java.util.*;


class IPAddress{
    public String defanging(String address) {
        String ans = "";
        for(int i=0; i<address.length(); i++) {
            char ch = address.charAt(i);
            if(ch=='.') {
                ans+="[.]";
            } else {
                ans+=ch;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        IPAddress IP = new IPAddress();
        System.out.println(IP.defanging("1.1.1.1"));
        System.out.println(IP.defanging("255.100.50.0"));
    }
}