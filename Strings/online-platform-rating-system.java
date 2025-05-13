/*Problem: (Asked in Visa coding test) Imagine that you are monitoring changes to user ratings for an online platform. Each
    user on this platform has an overall rating (an integer between 1 and 2500) and a corresponding level. Rating levels are based
    on the following rules:
      1. rating < 1000 = "beginner"
      2. 1000 <= rating < 1500 = "intermediate"
      3. 1500 <= rating < 2000 = "advanced"
      4. 2000 <= rating = "pro"

    You are given an initial rating value and an array of integers changes representing changes to the rating. Your task is to calculate 
    the final rating and return the level corresponding to that rating. It is guaranteed that changes to the rating value will never result
    in it becoming less than 1 or greater than 2500.
*/




import java.io.*;
import java.util.*;

class RatingSystem {
    public String finalRating(int initial, int[] changes) {
        int overallRating = initial;
        for(int i=0; i<changes.length; i++) {
            overallRating+=changes[i];
        }
        
        if(overallRating < 1000) {
            return "beginner";
        } else if(overallRating <= 1500 && overallRating >= 1000) {
            return "intermediate";
        } else if(overallRating <= 2000 && overallRating >= 1500) {
            return "advanced";
        }
        return "pro";
    } 
}

class Main {
    public static void main(String[] args) {
        RatingSystem rating = new RatingSystem();
        int[] changes = {-100, -300, 450, 500, -500, -600};
        System.out.println(rating.finalRating(1500, changes));
        
        int[] changes1 = {100, 200, 300, 400, -500};
        System.out.println(rating.finalRating(1500, changes1));
    }
}