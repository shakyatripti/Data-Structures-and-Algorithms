/*Problem: (Asked in Visa coding test) Imagine you're part of a team analyzing fictional alien technology logs. You have a string alienCode, 
    which represents activity codes from their devices. Your task is to examine this string and count how many substrings of this code 
    represent numbers evenly divisible by 3. It's important to note that none of these substrings should start with zero unless the substring 
    is the character "0" itself.
*/




import java.io.*;
import java.util.*;


class AlienCode {
    public int decodeCode(String code) {
        int count = 0;
        for(int i=0; i<code.length(); i++) {
            for(int j=i; j<code.length(); j++) {
                String str = code.substring(i, j+1);
                if(str.charAt(0)!='0' || str.equals("0")) {
                    int num = Integer.parseInt(str);
                    if(num % 3 == 0) {
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
        AlienCode code = new AlienCode();
        System.out.println(code.decodeCode("303"));
        System.out.println(code.decodeCode("6666"));
        System.out.println(code.decodeCode("456"));
    }
}