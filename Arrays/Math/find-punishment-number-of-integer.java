//Problem: https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/


import java.util.*;
import java.io.*;

class PunishmentNumber {
    public int findFunishment(int n) {
        int ans = 0;
        int nums[] =  {1,9,10,36,45,55,82,91,99,100,235,297,369,370,379,414,657,675,703,756,792,909,918,945,964,990,991,999,1000};
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<=n) {
                ans+=nums[i] * nums[i];
            } else {
                break;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        PunishmentNumber number = new PunishmentNumber();
        System.out.println(number.findFunishment(10));
        System.out.println(number.findFunishment(37));
    }
}