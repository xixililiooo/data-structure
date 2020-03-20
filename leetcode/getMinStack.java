package leetcode;

import java.util.Stack;

import javax.management.RuntimeErrorException;

public class getMinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public getMinStack(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public void push(int value){
       if(stack2.isEmpty()){
           stack2.push(value);
       }else if(stack2.peek() >= value){
           stack2.push(value);
       }
       stack1.push(value);
    }
    public void pop(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeErrorException(null, "your stack is empty");
        }else if(stack1.pop()<=stack2.peek()){
            stack2.pop();
        }
    }
    public int getMin(){
        return stack2.peek();
    }
}
/* test code
        getMinStack getminstack = new getMinStack();
        getminstack.push(3);
        getminstack.push(4);
        getminstack.push(5);
        getminstack.push(1);
        getminstack.push(2);
        System.out.print(getminstack.getMin());
*/