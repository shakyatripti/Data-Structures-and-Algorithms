//Problem: https://www.naukri.com/code360/problems/sort-a-stack_985275?leftPanelTabValue=PROBLEM



import java.io.*;
import java.util.*;

class SortStack {
    public void sortStack(Stack<Integer> stack) {
        sorting(stack);
    }
    
    public void sorting(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sorting(st);
        insertAtPosition(st, top);
    }
    
    public void insertAtPosition(Stack<Integer> st, int element) {
        if(st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertAtPosition(st, element);
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
        SortStack obj = new SortStack();
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(-2);
        st.push(9);
        st.push(-7);
        st.push(3);
        obj.sortStack(st);
        obj.display(st);
    }
}