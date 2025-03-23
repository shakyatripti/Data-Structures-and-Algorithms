//Problem: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/


/*Problem statement: There are n stores and there are quantities.length no. of products and their quantities are given in that array.
    Stores may receive 0 products. We need to distribute all the products among the stores so that minimum number of products is 
    distributed among the stores. For example 11 and 6 are the quantities of two products, we need to distribute them in 6 stores.
    Lets say we distribute 5 of product1 to store1, remaining(11-5) 6 of product1 to store2 and 6 of product2 to store3. Remaining stores
    will have 0 products. In this case 6 is the max product received by any store. Similarly we need to find min no. that will work for distribution.

    NOTE: In worst case we will distribute maxQuantity products to one of the stores.
*/



import java.io.*;
import java.util.*;

class MinMaxProductDistribution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxQuantity = 0;
        for(int i=0; i<quantities.length; i++) {
            maxQuantity = Math.max(quantities[i], maxQuantity);
        }
        
        int l=1, r=maxQuantity;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(isDistributed(quantities, mid, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    public boolean isDistributed(int[] quantities, int mid, int n) {
        int totalStores=0;
        for(int i=0; i<quantities.length; i++) {
            totalStores+=quantities[i]/mid;
            if(quantities[i]%mid!=0) {
                totalStores++;
            }
            
            if(totalStores > n) {
                return false;
            }
        }
        return totalStores <= n;
    }
}

class Main {
    public static void main(String[] args) {
        int[] quantities = {15,10,10};
        MinMaxProductDistribution products = new MinMaxProductDistribution();
        System.out.println(products.minimizedMaximum(7, quantities));
        
        int[] quantities2 = {11,6};
        System.out.println(products.minimizedMaximum(6, quantities2));
    }
}