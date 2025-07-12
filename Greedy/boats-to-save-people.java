//Problem: https://leetcode.com/problems/boats-to-save-people/description/




import java.io.*;
import java.util.*;


class SavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int l=0, r=people.length-1, boats=0;
        Arrays.sort(people);
        while(l <= r) {
            if(people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            boats++;
        }
        return boats;
    }
}

class Main {
    public static void main(String[] args) {
        SavePeople boats = new SavePeople();
        int[] people = {3,2,2,1};
        System.out.println(boats.numRescueBoats(people, 3));
        
        int[] people1 = {3,5,3,4};
        System.out.println(boats.numRescueBoats(people1, 5));
        
        int[] people2 = {5,1,4,2};
        System.out.println(boats.numRescueBoats(people2, 6));
        
        int[] people3 = {1,2};
        System.out.println(boats.numRescueBoats(people3, 3));
    }
}