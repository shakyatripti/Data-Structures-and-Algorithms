//Problem: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/





import java.io.*;
import java.util.*;

class DigitSwapsByParity {
    public int largestInteger(int num) {
        StringBuilder ans = new StringBuilder("");
        int size = 0, org = num, idx = 0, idx1 = 0;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        while(num!=0) {
            int r = num%10;
            num=num/10;
            if(r%2!=0) {
                odd.add(r);
            } else {
                even.add(r);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);

        while(org!=0) {
            int r = org%10;
            if(r%2==0) {
                ans.append(even.get(idx));
                idx++;
            } else {
                ans.append(odd.get(idx1));
                idx1++;
            }
            org = org/10;
        }
        return Integer.valueOf(ans.reverse().toString());
    }
}


class Main {
    public static void main(String[] args) {
        DigitSwapsByParity digits = new DigitSwapsByParity();
        System.out.println(digits.largestInteger(1234));
        System.out.println(digits.largestInteger(65875));
        System.out.println(digits.largestInteger(247));
    }
}