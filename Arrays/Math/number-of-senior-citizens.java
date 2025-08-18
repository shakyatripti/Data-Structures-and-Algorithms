//Problem: https://leetcode.com/problems/number-of-senior-citizens/description/




import java.io.*;
import java.util.*;

class SeniorCitizens {
    public int countSeniors(String[] details) {
        int citizens = 0;
        for(int i=0; i<details.length; i++) {
            String str = details[i].substring(11, 13);
            int age = Integer.valueOf(str);
            if(age > 60) {
                citizens++;
            }
        }
        return citizens;
    }
}

class Main {
    public static void main(String[] args) {
        SeniorCitizens citizens = new SeniorCitizens();
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(citizens.countSeniors(details));
        
        String[] details2 = {"1313579440F2036","2921522980M5644"};
        System.out.println(citizens.countSeniors(details2));
    }
}