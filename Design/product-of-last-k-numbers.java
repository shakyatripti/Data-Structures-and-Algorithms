//Problem: https://leetcode.com/problems/product-of-the-last-k-numbers/description/


//Brute force solution
import java.util.*;
import java.io.*;

class ProductOfNumbers {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public ProductOfNumbers() {
        arr = new ArrayList<Integer>();
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        for(int i=0; i<k; i++) {
            product = product * arr.get(arr.size()-1-i);
        }
        return product;
    }
}

class Main {
    public static void main(String[] args) {
        ProductOfNumbers prod = new ProductOfNumbers();
        prod.add(3);
        prod.add(0);
        prod.add(2);
        prod.add(5);
        prod.add(4);
        System.out.println(prod.getProduct(2));
        System.out.println(prod.getProduct(3));
        System.out.println(prod.getProduct(4));
        prod.add(8);
        System.out.println(prod.getProduct(2));
    }
}

//Optimal solution
import java.util.*;
import java.io.*;

class ProductOfNumbers {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int product = 1;
    public ProductOfNumbers() {
        arr = new ArrayList<Integer>();
    }
    
    public void add(int num) {
        if(num==0) {
            product = 1;
            arr = new ArrayList<Integer>();
            return;
        }
        product = product * num;
        arr.add(product);
    }
    
    public int getProduct(int k) {
        if(arr.size() < k) {
            return 0;
        }
        int ans = arr.get(arr.size()-1);
        if(arr.size()==k) {
            return ans;
        }
        return ans / arr.get(arr.size()-1-k);
    }
}

class Main {
    public static void main(String[] args) {
        ProductOfNumbers prod = new ProductOfNumbers();
        prod.add(3);
        prod.add(0);
        prod.add(2);
        prod.add(5);
        prod.add(4);
        System.out.println(prod.getProduct(2));
        System.out.println(prod.getProduct(3));
        System.out.println(prod.getProduct(4));
        prod.add(8);
        System.out.println(prod.getProduct(2));
    }
}