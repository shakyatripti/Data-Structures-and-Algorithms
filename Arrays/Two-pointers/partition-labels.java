//Problem: https://leetcode.com/problems/partition-labels/description/


//Brute Force solution
import java.io.*;
import java.util.*;

class PartitionLabels {
    public List<Integer> partitions(String s) {
        HashMap<Character, int[]> mp = new HashMap<Character, int[]>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(mp.containsKey(ch)) {
                int firstOccurence = mp.get(ch)[0];
                mp.put(ch, new int[]{firstOccurence, i});
            } else {
                mp.put(ch, new int[]{i,i});
            }
        }
        
        int[][] intervals = new int[mp.size()][2];
        int k=0;
        for(Map.Entry entry: mp.entrySet()) {
            int[] pos = (int[]) entry.getValue();
            intervals[k] = pos;
            k++;
        }
        
        List<int[]> merged = mergeIntervals(intervals);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<merged.size(); i++) {
            ans.add(merged.get(i)[1] - merged.get(i)[0] + 1);
        }
        return ans;
    }
    
    public List<int[]> mergeIntervals(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (x,y)-> Integer.compare(x[0], y[0]));
        ans.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            int[] prev = ans.get(ans.size()-1);
            if(intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
                prev[0] = Math.min(prev[0], intervals[i][0]);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans;
    }
    
    public void display(List<Integer> ans) {
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels labels = new PartitionLabels();
        List<Integer> ans = labels.partitions(s);
        labels.display(ans);
        
        String s1 = "caedbdedda";
        List<Integer> ans2 = labels.partitions(s1);
        labels.display(ans2);
        
        String s2 = "eccbbbbdec";
        List<Integer> ans3 = labels.partitions(s2);
        labels.display(ans3);
    }
}




//Optimal solution
import java.io.*;
import java.util.*;

class PartitionLabels {
    public List<Integer> partitions(String s) {
        int[] lastOccurrence = new int[26];
        for(int i=0; i<s.length(); i++) {
            lastOccurrence[s.charAt(i)-'a'] = i;
        }
        
        int partitionStart=0, partitionEnd=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i)-'a']);
            if(i==partitionEnd) {
                ans.add(partitionEnd - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return ans;
    }
    
    public void display(List<Integer> ans) {
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels labels = new PartitionLabels();
        List<Integer> ans = labels.partitions(s);
        labels.display(ans);
        
        String s1 = "caedbdedda";
        List<Integer> ans2 = labels.partitions(s1);
        labels.display(ans2);
        
        String s2 = "eccbbbbdec";
        List<Integer> ans3 = labels.partitions(s2);
        labels.display(ans3);
    }
}