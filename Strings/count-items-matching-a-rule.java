//Problem: https://leetcode.com/problems/count-items-matching-a-rule/description/





import java.io.*;
import java.util.*;

class MatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0;
        if(ruleKey.equals("color")) {
            ans = count(items, 1, ruleValue);
        }
        if(ruleKey.equals("type")) {
            ans = count(items, 0, ruleValue);
        }
        if(ruleKey.equals("name")) {
            ans = count(items, 2, ruleValue);
        }
        return ans;
    }

    public int count(List<List<String>> items, int key, String value) {
        int total = 0;
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).get(key).equals(value)) {
                total++;
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        MatchingRule rule = new MatchingRule();
        List<List<String>> items = new ArrayList<>();
		items.add(new ArrayList<>(Arrays.asList("phone","blue","pixel")));
		items.add(new ArrayList<>(Arrays.asList("computer","silver","lenovo")));
		items.add(new ArrayList<>(Arrays.asList("phone","gold","iphone")));
        System.out.println(rule.countMatches(items, "color", "silver"));
        
        List<List<String>> items1 = new ArrayList<>();
		items1.add(new ArrayList<>(Arrays.asList("phone","blue","pixel")));
		items1.add(new ArrayList<>(Arrays.asList("computer","silver","lenovo")));
		items1.add(new ArrayList<>(Arrays.asList("phone","gold","iphone")));
        System.out.println(rule.countMatches(items1, "type", "phone"));
    }
}