package Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_Stack {

    static class MinStack{
        private Deque<Integer> stack;
        private Deque<Integer> minStack;
        public MinStack(){
            stack=new ArrayDeque<>();
            minStack=new ArrayDeque<>();
        }
        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty()){
                minStack.push(x);
            }
            else {
                minStack.push(Math.min(x,minStack.peek()));
            }
        }
        public void pop(){
            if(!stack.isEmpty()){
                stack.pop();
                minStack.pop();
            }
        }
        public int top(){
            return stack.peek();
        }
        public int getMin(){
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MinStack minStack=new MinStack();

        while (sc.hasNextLine()){
            String op=sc.nextLine().trim();

            if(op.startsWith("push")){
                int val=Integer.parseInt(op.substring(5,op.length()-1));
                minStack.push(val);
            } else if(op.equals("pop()")) {
                minStack.pop();
            }
            else if(op.equals("getMin()")){
                System.out.println(minStack.getMin());
            }
        }
    }
}