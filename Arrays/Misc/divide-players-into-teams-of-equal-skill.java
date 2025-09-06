//Problem: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/





import java.io.*;
import java.util.*;

class EqualSkill {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length - 1;
        long chemistry = 0;
        int sum = skill[0] + skill[n];
        for(int i=0; i<skill.length/2; i++) {
            int valSum = skill[i] + skill[n-i];
            if(sum!=valSum) {
                return -1;
            } else {
                chemistry+=skill[i] * skill[n-i];
            }
        }
        return chemistry;
    }
}

class Main {
    public static void main(String[] args) {
        EqualSkill teams = new EqualSkill();
        int[] skill = {3,2,5,1,3,4};
        System.out.println(teams.dividePlayers(skill));
        
        int[] skill1 = {2,4};
        System.out.println(teams.dividePlayers(skill1));
        
        int[] skill2 = {1,1,2,3};
        System.out.println(teams.dividePlayers(skill2));
    }
}