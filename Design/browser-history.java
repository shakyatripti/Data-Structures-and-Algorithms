//Problem: https://leetcode.com/problems/design-browser-history/description/




import java.io.*;
import java.util.*;

class BrowserHistory {
    ArrayList<String> arr = new ArrayList<>();
    int k=0;
    public BrowserHistory(String homepage) {
        arr = new ArrayList<>();
        arr.add(homepage);
        k=0;
    }
    
    public void visit(String url) {
        while(arr.size() > k+1) {
            arr.remove(arr.size()-1);
        }
        arr.add(url);
        k++;
    }
    
    public String back(int steps) {
        if(steps > k) {
            k=0;
            return arr.get(0);
        }
        k=k-steps;
        return arr.get(k);
    }
    
    public String forward(int steps) {
        if(k+steps >= arr.size()) {
            k=arr.size()-1;
            return arr.get(arr.size()-1);
        }
        k=k+steps;
        return arr.get(k);
    }
}

class Main {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));
        browser.visit("linkedin.com");
        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.back(7));
    }
}