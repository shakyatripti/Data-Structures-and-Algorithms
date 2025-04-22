//Problem Statement: For given n, generate all possible binary strings of length n. Ex : n=2 , binary strings will be [01,10,11,00]



import java.io.*;
import java.util.*;

class GenerateAllBinaryStrings {
    public List<int[]> binaryStrings(int n) {
        List<int[]> result = new ArrayList<>();
        int[] ans = new int[n]; 
        generate(result, ans, 0, n);
        return result;
    }
    
    public void generate(List<int[]> result, int[] ans, int i, int n) {
        if(i==n) {
            result.add(ans.clone());
            return;
        }
        ans[i]=0;
        generate(result, ans, i+1, n);
        ans[i]=1;
        generate(result, ans, i+1, n);
    }
    
    public void display(List<int[]> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).length; j++) {
                System.out.print(ans.get(i)[j] + " ");
            }
            System.out.print("\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        GenerateAllBinaryStrings str = new GenerateAllBinaryStrings();
        List<int[]> ans = str.binaryStrings(3);
        str.display(ans);
    }
}