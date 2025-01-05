// Problem: https://leetcode.com/problems/palindrome-number/

//1st Solution : Beats 30% complexity

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
          return false;
        }
        String ch = String.valueOf(x);
        int len = ch.length();
        for(int i=0; i<=len/2; i++) {
            if(ch.charAt(i) != ch.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}

//2nd Solution: Beats 100% complexity

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
          return false;
        }
        int rev=0, n=x;
        while(n!=0) {
            int r=n%10;
            n=n/10;
            rev=(rev*10) + r;
        }
        if(rev!=x) {
            return false;
        }
        return true;
    }
}