//Problem: https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/description/





import java.io.*;
import java.util.*;

class ExcelSheet {
    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<String>();
        int letter1 = s.charAt(0) - 'A', letter2 = s.charAt(3) - 'A';
        int start = s.charAt(1) - '0', end = s.charAt(4) - '0';
         for(int j=letter1; j<=letter2; j++) {
            for(int i=start; i<=end; i++) {
                char ch = (char) (j + 'A');
                char ch1 = (char) (i + '0');
                StringBuilder str = new StringBuilder();
                str.append(ch);
                str.append(ch1);
                ans.add(str.toString());
            }
        }
        return ans;
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ExcelSheet sheet = new ExcelSheet();
        List<String> ans = sheet.cellsInRange("K1:L2");
        sheet.display(ans);
        
        List<String> ans1 = sheet.cellsInRange("A1:F1");
        sheet.display(ans1);
    }
}