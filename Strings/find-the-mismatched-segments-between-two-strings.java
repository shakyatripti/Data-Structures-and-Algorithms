//Problem:
https://leetcode.com/problems/find-mismatched-segments-between-two-strings/description 




import java.io.*;
import java.util.*;

class MismatchedSegments {

    public List<List<String>> findSegments(String s1, String s2) {

        List<List<String>> ans = new ArrayList<>();

        int i = 0;

        while (i < s1.length()) {

            if (s1.charAt(i) != s2.charAt(i)) {

                String str1 = "";
                String str2 = "";

                while (i < s1.length() && s1.charAt(i) != s2.charAt(i)) {
                    str1 += s1.charAt(i);
                    str2 += s2.charAt(i);
                    i++;
                }

                List<String> res = new ArrayList<>();
                res.add(str1);
                res.add(str2);
                ans.add(res);

            } else {
                i++;
            }
        }

        return ans;
    }

    public void display(List<List<String>> ans) {

        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {

    public static void main(String[] args) {

        MismatchedSegments str = new MismatchedSegments();

        List<List<String>> ans = str.findSegments("earth", "empty");
        str.display(ans);

        List<List<String>> ans1 = str.findSegments("action", "nation");
        str.display(ans1);

        List<List<String>> ans2 = str.findSegments("hot", "hot");
        str.display(ans2);
    }
}
