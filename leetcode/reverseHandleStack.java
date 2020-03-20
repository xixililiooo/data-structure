package leetcode;

import java.util.Stack;

/**
 * 只依赖栈和递归实现把栈中元素逆序存储
 */
public class reverseHandleStack{
    Stack<Integer> stack1;
    public reverseHandleStack(){
        stack1 = new Stack<Integer>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        reverse(stack1);
        System.out.print(stack1.pop());
        System.out.print(stack1.pop());
        System.out.print(stack1.pop());
    }
    //将栈底中的元素拿出来
    public int getLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last  = getLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else{
            int el = getLastElement(stack);
            reverse(stack);
            stack.push(el);
        }
    }
}