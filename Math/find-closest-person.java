//Problem: https://leetcode.com/problems/find-closest-person/description/



import java.io.*;
import java.util.*;

class ClosestPerson {
    public int findClosest(int x, int y, int z) {
        int person1 = Math.abs(x-z);
        int person2 = Math.abs(y-z);
        if(person1 < person2) {
            return 1;
        }
        if(person1 > person2) {
            return 2;
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        ClosestPerson person = new ClosestPerson();
        System.out.println(person.findClosest(2,7,4));
        System.out.println(person.findClosest(2,5,6));
        System.out.println(person.findClosest(1,5,3));
    }
}