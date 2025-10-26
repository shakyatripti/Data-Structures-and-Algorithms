//Problem: https://leetcode.com/problems/simple-bank-system/description/





import java.io.*;
import java.util.*;

class Bank {
    HashMap<Integer, Long> mp = new HashMap<>();
    public Bank(long[] balance) {
        for(int i=0; i<balance.length; i++) {
            mp.put(i+1, balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!mp.containsKey(account1) || !mp.containsKey(account2) || mp.get(account1) < money) {
            return false;
        } else {
            long balance1 = mp.get(account1);
            mp.put(account1, balance1 - money);
            long balance2 = mp.get(account2);
            mp.put(account2, balance2 + money);
        }
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!mp.containsKey(account)) {
            return false;
        } else {
            mp.put(account, mp.get(account) + money);
        }
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!mp.containsKey(account)  || mp.get(account) < money) {
            return false;
        } else {
            long available = mp.get(account);
            mp.put(account, available-money);
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Bank obj = new Bank(balance);
        System.out.print(obj.withdraw(3,10) + " ");
        System.out.print(obj.transfer(5,1,20) + " ");
        System.out.print(obj.deposit(5,20) + " ");
        System.out.print(obj.transfer(3,4,15) + " ");
        System.out.print(obj.withdraw(10,50) + " ");
        
        System.out.println();
        
        long[] balance1 = {22,34,12,59,0,58,61,83};
        Bank obj1 = new Bank(balance1);
        System.out.print(obj1.withdraw(24,16) + " ");
        System.out.print(obj1.deposit(7,40) + " ");
        System.out.print(obj1.deposit(1,10) + " ");
        System.out.print(obj1.deposit(6,90) + " ");
        System.out.print(obj1.transfer(8,7,65) + " ");
        System.out.print(obj1.transfer(4,55,80) + " ");
        System.out.print(obj1.withdraw(70,19) + " ");
        
        System.out.println();
        
        long[] balance2 = {0};
        Bank obj2 = new Bank(balance2);
        System.out.print(obj2.deposit(1,2) + " ");
        System.out.print(obj2.transfer(1,1,1) + " ");
        System.out.print(obj2.transfer(1,1,3) + " ");
    }
}