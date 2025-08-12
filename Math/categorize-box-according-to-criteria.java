//Problem: https://leetcode.com/problems/categorize-box-according-to-criteria/description/




import java.io.*;
import java.util.*;

class CategorizeBox {
    public String criteriaCheck(int length, int width, int height, int mass) {
        long volume = (long) (length * width) * height;
        boolean isBulky = false, isHeavy = false;
        if((volume >= 1000000000) || (length >= 10000 || width >= 10000 || height >= 10000)) {
            isBulky = true;
        }
        if(mass >= 100) {
            isHeavy = true;
        }
        if(isBulky && isHeavy) {
            return "Both";
        } else if(isBulky && !isHeavy) {
            return "Bulky";
        } else if(!isBulky && isHeavy) {
            return "Heavy";
        }
        return "Neither";
    }
}


class Main {
    public static void main(String[] args) {
        CategorizeBox box = new CategorizeBox();
        System.out.println(box.criteriaCheck(1000, 35, 700, 300));
        System.out.println(box.criteriaCheck(200, 50, 800, 50));
        System.out.println(box.criteriaCheck(2909, 3968, 3272, 727));
        System.out.println(box.criteriaCheck(10000, 10, 10, 2));
    }
}