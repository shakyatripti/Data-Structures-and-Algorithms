//Problem: https://leetcode.com/problems/count-days-spent-together/description/





import java.io.*;
import java.util.*;


class DaysSpentTogether {
    public int countDays(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceStart = getDay(arriveAlice, months);
        int aliceEnd = getDay(leaveAlice, months);
        int bobStart = getDay(arriveBob, months);
        int bobEnd = getDay(leaveBob, months);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int getDay(String date, int[] months) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        for (int i = 0; i < month - 1; i++) {
            day += months[i];
        }

        return day;
    }
}

class Main {
    public static void main(String[] args) {
        DaysSpentTogether meeting = new DaysSpentTogether();
        System.out.println(meeting.countDays("08-15", "08-18", "08-16", "08-19"));
        System.out.println(meeting.countDays("10-01", "10-31", "11-01", "12-31"));
        System.out.println(meeting.countDays("09-01", "10-19", "06-19", "10-20"));
    }
}