//Problem: https://leetcode.com/problems/snake-in-matrix/description/





import java.io.*;
import java.util.*;

class SnakeInMatrix {
    public int finalPosition(int n, List<String> commands) {
        int row=0, col=0;
        for(int i=0; i<commands.size(); i++) {
            String dir = commands.get(i);
            if(dir.equals("RIGHT")) {
                col = col + 1;
            } else if(dir.equals("DOWN")) {
                row = row + 1;
            } else if(dir.equals("UP")) {
                row = row - 1;
            } else {
                col = col - 1;
            }
        }
        return (row*n) + col;
    }
}

class Main {
    public static void main(String[] args) {
        SnakeInMatrix snake = new SnakeInMatrix();
        List<String> commands = new ArrayList<>(Arrays.asList("RIGHT","DOWN"));
        System.out.println(snake.finalPosition(2, commands));
        
        List<String> commands1 = new ArrayList<>(Arrays.asList("DOWN","RIGHT","UP"));
        System.out.println(snake.finalPosition(3, commands1));
        
    }
}