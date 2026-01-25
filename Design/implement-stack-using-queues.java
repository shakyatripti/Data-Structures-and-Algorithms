//Problem: https://leetcode.com/problems/implement-stack-using-queues/description/





import java.io.*;
import java.util.*;

class MyStack {
    Deque<Integer> q = new ArrayDeque<>();
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.addLast(x);
    }
    
    public int pop() {
        return q.pollLast();
    }
    
    public int top() {
        return q.peekLast();
    }
    
    public boolean empty() {
        if(!q.isEmpty()) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.empty());
    }
}