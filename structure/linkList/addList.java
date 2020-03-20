package structure.linkList;

import java.util.Stack;

//链表中每一个节点的值都在0-9之间，那么每个链表都可以表示为一个数字
//比如9->3->7 表示937
//给定两个头结点head1和head2，请生成新的结果链表
public class addList{
    //如果直接每个节点地取数字组成数字然后相加再分解成链表有可能会溢出
    //所以做法就是利用栈结构
    public static Node add(Node head1,Node head2){
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        while(head1!=null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2!=null){
            stack1.push(head2);
            head2 = head2.next;
        }
        int cur1 = 0;
        int cur2 = 0;
        int ca = 0;  //标志进位
        int cur = 0;
        Node node = null;
        Node pre = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            cur1 = stack1.isEmpty()?0:stack1.pop().value;
            cur2 = stack2.isEmpty()?0:stack2.pop().value;
            if(cur1+cur2+ca>=10){
                cur = cur1+cur2+ca-10;
                ca = 1;
            }else{
                cur = cur1+cur2+ca;
            }
            node = new Node(cur);
            node.next = pre;
            pre = node;
        }
        if(ca==1){
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    //还有另外一种解法就是把反转两个链表，然后遍历两个链表进行相加，加上进位
    public static void main(String[] args){

    }
}