//Problem: https://leetcode.com/problems/compare-version-numbers/description/





import java.io.*;
import java.util.*;

class CompareVersionsNumbers {
    public int compareVersion(String version1, String version2) {
        String[] part1 = version1.split("\\.");
        String[] part2 = version2.split("\\.");
        int size = 0;
        if(part1.length > part2.length) {
            size = part1.length;
        } else {
            size = part2.length;
        }
        for(int i=0; i<size; i++) {
            int val1=0, val2=0;
            if(i < part1.length) {
                val1 = Integer.valueOf(part1[i]);
            }
            if(i < part2.length) {
                val2 = Integer.valueOf(part2[i]);
            }
            if(val1 < val2) {
                return -1;
            }
            if(val1 > val2) {
                return 1;
            }
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        CompareVersionsNumbers nums = new CompareVersionsNumbers();
        System.out.println(nums.compareVersion("1.2", "1.10"));
        System.out.println(nums.compareVersion("1.01", "1.001"));
        System.out.println(nums.compareVersion("1.0", "1.0.0.0"));
        System.out.println(nums.compareVersion("1", "0"));
    }
} 