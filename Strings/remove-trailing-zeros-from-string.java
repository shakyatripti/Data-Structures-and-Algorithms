//Problem: https://leetcode.com/problems/remove-trailing-zeros-from-a-string/description/




//Better solution
import java.io.*;
import java.util.*;

class RemoveTrailingZeros {
	public String remove(String num) {
        int countZeroes = 0, n=num.length();
        for(char ch: num.toCharArray()) {
            if(ch=='0') {
                countZeroes++;
            } else {
                countZeroes = 0;
            }
        }
        return num.substring(0, n-countZeroes);
    }
}

class Main {
	public static void main(String[] args) {
		RemoveTrailingZeros str = new RemoveTrailingZeros();
		System.out.println(str.remove("51230100"));
		System.out.println(str.remove("123"));
	}
}




//Optimal solution
import java.io.*;
import java.util.*;

class RemoveTrailingZeros {
	public String remove(String num) {
        int n=num.length();
        for(int i=n-1; i>=0; i--) {
            if(num.charAt(i)!='0') {
                return num.substring(0, i+1);
            }
        }
        return num;
    }
}

class Main {
	public static void main(String[] args) {
		RemoveTrailingZeros str = new RemoveTrailingZeros();
		System.out.println(str.remove("51230100"));
		System.out.println(str.remove("123"));
	}
}