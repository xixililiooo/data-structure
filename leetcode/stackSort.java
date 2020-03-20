package leetcode;

import java.util.Stack;

public class stackSort {
    Stack<Integer> stack;
    Stack<Integer> help;
    public stackSort(){
        stack =  new Stack<Integer>();
        help = new Stack<Integer>();  //使用辅助栈来帮助排序，思想像单调栈
        stack.push(3);
        stack.push(9);
        stack.push(100);
        stack.push(1);
        stack.push(50);
        stack.push(45);
        sort();
        while(!help.isEmpty()){
            System.out.println(help.pop());
        }
    }
    public void sort(){
        while(!stack.isEmpty()){
            int el = stack.pop();
            while(!help.isEmpty()&&help.peek()<el){
                stack.push(help.pop());
            }
                help.push(el);
        }
    }
}