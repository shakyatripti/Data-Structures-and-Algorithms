//Problem: https://leetcode.com/problems/coupon-code-validator/description/






import java.io.*;
import java.util.*;

class CouponCodeValidator {
    public List<String> validate(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        List<String> validBusiness = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        HashMap<String, List<String>> mp = new HashMap<>();
        for(int i=0; i<code.length; i++) {
            if(code[i].length()!=0 && validBusiness.contains(businessLine[i]) && isActive[i]==true) {
                if(isValidCode(code[i])) {
                    if(mp.containsKey(businessLine[i])) {
                        List<String> ch = mp.get(businessLine[i]);
                        ch.add(code[i]);
                        mp.put(businessLine[i], ch);
                    } else {
                        List<String> ch = new ArrayList<>();
                        ch.add(code[i]);
                        mp.put(businessLine[i], ch);
                    }
                }
            }
        }

        for(int i=0; i<validBusiness.size(); i++) {
            String b = validBusiness.get(i);
            if(mp.containsKey(b)) {
                List<String> category = mp.get(b);
                Collections.sort(category);
                for(int j=0; j<category.size(); j++) {
                    ans.add(category.get(j));
                }
            }
        }
        return ans;
    }

    public boolean isValidCode(String code) {
        boolean flag = true;
        for(int i=0; i<code.length(); i++) {
            int ch = code.charAt(i) - '0';
            if((ch>=17 && ch<=42) || (ch>=49 && ch<=74) || (ch>=0 && ch<=9) || (ch==47)) {
                flag = true;
            } else {
                return false;
            }
        }
        return true;
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
        CouponCodeValidator coupons = new CouponCodeValidator();
        String[] code = {"SAVE20","AZaz09_","PHARMA5","SAVE_20"};
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};
        List<String> ans = coupons.validate(code, businessLine, isActive);
        coupons.display(ans);
        
        String[] code1 = {"GROCERY15","ELECTRONICS_50","DISCOUNT10"};
        String[] businessLine1 = {"grocery","electronics","invalid"};
        boolean[] isActive1 = {false,true,true};
        List<String> ans1 = coupons.validate(code1, businessLine1, isActive1);
        coupons.display(ans1);
        
        String[] code2 = {"pBXoMqBU0_aMgc9F8dy6TaSzza3KjSJFjxZa_NuyMjzEBR7fJNwpGHh7lzuoZvQeEUeo6YumHmIOjjchXlzSVa4ItdyDOImQgm","P8rIIUl35MW8yrqRbO0N_IITptYOxz9tOCbPL6d1aIF_hM2sapaDtUzNpmAZRmJQB1WgjLh8bdYADuSRSU21OzttUkq73qiA66","aFWkYookQlHYMXzhVGxbnrXIl1810ws3qHtketHSECHqJoktWXVZGc6ZyeOuzA_VL9zFL9znpIHwbkwJF2bOPQqsz3_0PYgETJ"};
        String[] businessLine2 = {"pharmacy","invalid","pharmacy"};
        boolean[] isActive2 = {true,true,true};
        List<String> ans2 = coupons.validate(code2, businessLine2, isActive2);
        coupons.display(ans2);
    }
}