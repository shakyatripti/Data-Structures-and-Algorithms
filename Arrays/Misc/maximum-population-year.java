//Problem: https://leetcode.com/problems/maximum-population-year/description/




import java.io.*;
import java.util.*;


class MaximumPopulation {
    public int earliestYear (int[][] logs) {
        int earliestYear = 0, maxPopulation = 0;
        int[] year = new int[101];
        for(int i=0; i<logs.length; i++) {
            int start = logs[i][0];
            int end = logs[i][1];
            calcPopulation(start, end, year);
        }

        for(int i=0; i<100; i++) {
            if(year[i] > maxPopulation) {
                maxPopulation = year[i];
                earliestYear = i + 1950;
            }
        }
        return earliestYear;
    }

    public void calcPopulation(int start, int end, int[] year) {
        for(int i=start; i<end; i++) {
            year[i-1950]++;
        }
    }
}


class Main {
    public static void main(String[] args) {
        MaximumPopulation person = new MaximumPopulation();
        int[][] logs = {{1993,1999},{2000,2010}};
        System.out.println(person.earliestYear(logs));
        
        int[][] logs1 = {{1950,1961},{1960,1971},{1970,1981}};
        System.out.println(person.earliestYear(logs1));
    }
}