package structure.linkList;

import sun.util.logging.resources.logging;

//判断两个链表是否相交，如果相交返回相交的节点
//解决这道题的思路主要如下：
//首先要判断两个链表的成环情况
//第一种就是一个链表有一个链表没有，这种情况不可能存在相交节点
//第二种就是两个链表都没有环，那形成的可能就是 Y 字型
//第三种情况就是一个链表有环一个链表无环，可能形成 Y+O，也有可能是另一种
//所以我们要定义一个函数，用来判断链表是否有环，如果形成环那就返回入环节点
//然后根据这个函数判断两个链表的成环情况，然后再分情况去解决。
public class getInsertNode{
    public static Node getloopNode(Node head){
        //怎么判断一个链表是否成环
        //使用的是双指针法，一个叫做慢指针，一个叫做快指针
        //快指针一次走两步，慢指针一次走一步，然后在走的时候中要判断是否走到了尾巴，如果走到了尾巴一定无环返回Null
        //然后等待快指针和满指针同时指向一个节点的时候，让慢指针重新返回到head节点，然后两个指针同时走一步直到两个指针同时指向一个节点
        //这时两个指针指向的节点就是入环节点
        if(head==null || head.next==null || head.next.next==null){
            return null;
        }
        Node fast = head.next.next;  //快指针
        Node slow = head.next;  //慢指针
        while(fast!=slow){
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static Node bothLoop(Node loop1,Node loop2,Node head1,Node head2){
        //两个链表都都有环的情况
        if(loop1 == loop2){   //情况一,跟Y字形的解决方法一致
            return getYNode(head1, head2);
        }else{
            Node next = loop1.next;
            while(next!=loop1){
                if(next == loop2){
                    return loop1;
                }
                next = next.next;
            }
            return null;
        }
    }
    public static Node getYNode(Node head1,Node head2){
        int l1 = 0;
        int l2 = 0;
        Node head11 = head1;
        Node head22 = head2;
        while(head11.next!=null){
            ++l1;
            head11  = head11.next;
        }
        while(head22.next!=null){
            ++l2;
            head22 = head22.next;
        }
        if(head11!=head22){
            return null;
        }
        Node longhead = l1>=l2?head1:head2;
        Node shorthead = l1>=l2?head2:head1;
        int step  = Math.abs(l1-l2);
        while(step!=0){
            longhead = longhead.next;
            step--;
        }
        while(longhead!=shorthead){
            longhead = longhead.next;
            shorthead = shorthead.next;
        }
        return longhead;
    }
    public static Node bothNoLoop(Node head1,Node head2){
        //两个链表都没有环的情况
        //对于Y字形的情况，我们需要得到两个链表的长度，然后让长的链表先走 链表长度的差值，然后同步走一步，直到相等
        //这样做的前提是他们确实相交，他们也有可能平行
       return getYNode(head1, head2);
    }
    public static Node getNode(Node head1,Node head2){
        Node loop1 = getloopNode(head1);
        Node loop2 = getloopNode(head2);
        if(loop1!=null && loop2!=null){  
            return bothLoop(loop1, loop2, head1, head2);
        }else if(loop1==null && loop2==null){
            return bothNoLoop(head1, head2);
        }else{
            return null;
        }
    }
    public static void main(String[] args){

    }
}