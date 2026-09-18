//Problem:
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/




import java.io.*;
import java.util.*;


class StudentsLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int n=students.length, m=sandwiches.length, start=0;
        for(int i=0; i<n; i++) {
            q.add(students[i]);
        }

        while(!q.isEmpty()) {
            int s = q.size(), size = 0;
            while(size!=s && q.peek()!=sandwiches[start]) {
                q.add(q.poll());
                size++;
            }

            if(size==s) {
                return q.size();
            } else {
                start++;
                q.poll();
            }
        }
        return q.size();
    }
}

class Main {
    public static void main(String[] args) {
        StudentsLunch lunch = new StudentsLunch();
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(lunch.countStudents(students, sandwiches));
        
        int[] students1 = {1,1,1,0,0,1};
        int[] sandwiches1 = {1,0,0,0,1,1};
        System.out.println(lunch.countStudents(students1, sandwiches1));
    }
}