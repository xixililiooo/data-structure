package structure.linkList;

import java.util.Stack;

public class isPalindrome {
    //最简单的方法就是利用一个栈空间把链表所有元素都放入栈中，然后遍历看是否相同
    //下面这种方法是将栈对半，只把右半部分放入栈中
    public static Boolean isP1(Node head){ 
        //先找到中间节点,这里稍加改变，因为要找的是下中间节点
        if(head==null) return true;
        if(head.next == null) return true;
        Node fast = head;
        Node slow = head.next;
        Stack<Node> stack = new Stack<Node>();
        while(fast.next!=null){
            if(fast.next.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(slow!=null){
            stack.push(slow);
            slow = slow.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop().value!=fast.value){
                return false;
            }
            fast = fast.next;
        }
        return true;

    }
   

    
    public static void main(String[] args){
       
    }
}