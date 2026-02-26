//Problem: https://leetcode.com/problems/account-balance-after-rounded-purchase/description/




import java.io.*;
import java.util.*;

class AccountBalance {
    public int afterPurchase(int purchaseAmount) {
        int r = purchaseAmount%10;
        int div = purchaseAmount/10;
        if(r >=5) {
            return 100 - ((div + 1)*10);
        }
        if(r!=0 && r<5) {
            return 100 - (div * 10);
        }
        return 100 - purchaseAmount;
    }
}

class Main {
    public static void main(String[] args) {
        AccountBalance balance = new AccountBalance();
        System.out.println(balance.afterPurchase(9));
        System.out.println(balance.afterPurchase(15));
        System.out.println(balance.afterPurchase(10));
        System.out.println(balance.afterPurchase(11));
        System.out.println(balance.afterPurchase(16));
        System.out.println(balance.afterPurchase(1));
    }
}