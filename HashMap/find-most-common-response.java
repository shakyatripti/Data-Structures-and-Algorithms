//Problem: https://leetcode.com/problems/find-the-most-common-response/description/




import java.io.*;
import java.util.*;

class MostCommonResponse {
    public String findCommon(List<List<String>> response) {
        HashMap<String, Integer> freq = new HashMap<>();
        for(int i=0; i<response.size(); i++) {
            Set<String> unique = new HashSet<>();
            for(int j=0; j<response.get(i).size(); j++) {
                String str = response.get(i).get(j);
                if(!unique.contains(str)) {
                    freq.put(str, freq.getOrDefault(str, 0) + 1);
                    unique.add(str);
                }
            }
        }
        
        String result="";
        int max = 0;
        for(Map.Entry entry: freq.entrySet()) {
            int count = (int) entry.getValue();
            String curr = entry.getKey().toString();
            if(count > max) {
                max = count;
                result = curr;
            }
            
            if(count==max && (result==null || curr.compareTo(result) < 0)) {
                result = curr;
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        MostCommonResponse res = new MostCommonResponse();
        List<List<String>> response = new ArrayList<>();
        response.add(Arrays.asList("good","ok","good","ok"));
        response.add(Arrays.asList("ok","bad","good","ok","ok"));
        response.add(Arrays.asList("good"));
        response.add(Arrays.asList("bad"));
        System.out.println(res.findCommon(response));
        
        List<List<String>> response2 = new ArrayList<>();
        response2.add(Arrays.asList("inx","inx","gv","inx"));
        System.out.println(res.findCommon(response2));
        
        List<List<String>> response3 = new ArrayList<>();
        response3.add(Arrays.asList("gk","otg","ia","otg","qs","cwtk"));
        response3.add(Arrays.asList("i","otg","otg","otg","otg","otg","otg"));
        System.out.println(res.findCommon(response3));
    }
}