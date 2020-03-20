package leetcode;

import java.util.Stack;
/*
    两个栈实现队列
*/
public class Leetcode09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Leetcode09() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.empty()&&stack1.empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                int ele = stack1.pop();
                stack2.push(ele);
            }
        }
        return stack2.pop();
       
    }
}