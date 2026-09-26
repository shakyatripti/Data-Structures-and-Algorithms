//Problem: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/description/




import java.io.*;
import java.util.*;

class BracketPairs {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mp = new HashMap<>();
        String ans = "";
        for(int i=0; i<knowledge.size(); i++) {
            mp.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(') {
                String curr = "";
                i++;
                while(s.charAt(i)!=')') {
                    curr+=s.charAt(i);
                    i++;
                }
                ans+=mp.get(curr)==null ? '?' : mp.get(curr);
            } else {
                ans+=ch;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        BracketPairs pairs = new BracketPairs();
        ArrayList<List<String>> knowledge = new ArrayList<List<String>>();
        knowledge.add(Arrays.asList("name", "bob"));
        knowledge.add(Arrays.asList("age","two"));
        System.out.println(pairs.evaluate("(name)is(age)yearsold", knowledge));
        
        ArrayList<List<String>> knowledge1 = new ArrayList<List<String>>();
        knowledge1.add(Arrays.asList("a", "b"));
        System.out.println(pairs.evaluate("hi(name)", knowledge1));
        
        ArrayList<List<String>> knowledge2 = new ArrayList<List<String>>();
        knowledge2.add(Arrays.asList("a", "yes"));
        System.out.println(pairs.evaluate("(a)(a)(a)aaa", knowledge2));
    }
}