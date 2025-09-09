//Problem: https://leetcode.com/problems/design-parking-system/description/




import java.io.*;
import java.util.*;

class ParkingSystem {
    int bigCar = 0, mediumCar = 0, smallCar = 0;
    public ParkingSystem(int big, int medium, int small) {
        bigCar = big;
        mediumCar = medium;
        smallCar = small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1 && bigCar > 0) {
            bigCar--;
            return true;
        }
        if(carType==2 && mediumCar > 0) {
            mediumCar--;
            return true;
        }
        if(carType==3 && smallCar > 0) {
            smallCar--;
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1,1,0);
        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }
}