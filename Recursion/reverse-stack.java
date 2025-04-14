//Problem: https://www.naukri.com/code360/problems/reverse-stack-using-recursion_631875?leftPanelTabValue=PROBLEM




//Brute force: Using two stacks
import java.io.*;
import java.util.*;

class ReverseStack {
    public void reverseStack(Stack<Integer> st) {
        reversed(st);
    }
    
    public void reversed(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reversed(st);
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()) {
            int first = st.pop();
            temp.add(first);
        }
        st.push(top);
        while(!temp.isEmpty()) {
            int first = temp.pop();
            st.add(first);
        }
    }
    
    public void display(Stack<Integer> st) {
        while(!st.isEmpty()) {
            int top = st.pop();
            System.out.print(top + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        ReverseStack obj = new ReverseStack();
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        obj.reverseStack(st);
        obj.display(st);
    }
}




//Optimal solution: Using memory stack
import java.io.*;
import java.util.*;

class ReverseStack {
    public void reverseStack(Stack<Integer> st) {
        reversed(st);
    }
    
    public void reversed(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reversed(st);
        insertAtBottom(st, top);
    }
    
    public void insertAtBottom(Stack<Integer> st, int element) {
        if(st.isEmpty()) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertAtBottom(st, element);
        st.push(top);
    }
    
    
    public void display(Stack<Integer> st) {
        while(!st.isEmpty()) {
            int top = st.pop();
            System.out.print(top + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        ReverseStack obj = new ReverseStack();
        Stack<Integer> st = new Stack<Integer>();
        st.push(5);
        st.push(4);
        st.push(6);
        st.push(3);
        st.push(9);
        obj.reverseStack(st);
        obj.display(st);
    }
}