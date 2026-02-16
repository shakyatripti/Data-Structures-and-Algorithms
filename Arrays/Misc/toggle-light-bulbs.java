//Problem: https://leetcode.com/problems/toggle-light-bulbs/description/





import java.io.*;
import java.util.*;

class LightBulbs {
    public List<Integer> toggleBulbs(List<Integer> bulbs) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<bulbs.size(); i++) {
            int b = bulbs.get(i);
            if(arr.contains(b)) {
                arr.remove(Integer.valueOf(b));
            } else {
                arr.add(b);
            }
        }
        Collections.sort(arr);
        return arr;
    }
    
    public void display(List<Integer> ans) {
        if(ans.size()==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LightBulbs arr = new LightBulbs();
        List<Integer> bulbs = new ArrayList<>(Arrays.asList(10,30,20,10));
        List<Integer> ans = arr.toggleBulbs(bulbs);
        arr.display(ans);
        
        List<Integer> bulbs1 = new ArrayList<>(Arrays.asList(100,100));
        List<Integer> ans1 = arr.toggleBulbs(bulbs1);
        arr.display(ans1);
    }
}