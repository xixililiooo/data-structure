package structure.linkList;

import java.util.List;

//将链表中元素进行两两翻转
//主要注意连接的顺序
public class doubleReserve{
    public Node tworeserve(Node head){
        Node newHead  = new Node(0);
        newHead.next = head;
        head = newHead;
        while(head.next!=null && head.next.next!=null){
            Node a = head.next;
            Node b  = a.next;
            head.next = b;
            a.next = b.next;
            b.next = a;
            head = a;
        }
        return newHead.next;
    }

    //k个一组反转链表
    public ListNode reserveK(ListNode head,int k){
        //思路就是每k个元素进行一次元素的反转操作
        //元素的反转操作之前已经写过,这里就直接定义一个方法
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        head  = newHead;
        ListNode end = head; //子链表的最后一个节点
        ListNode pre = head; //子链表第一个节点的上一个节点，用于反转后的连接
        while(end!=null){
            for(int i = 0;i<k && end!=null;i++){
                end = end.next;
            }
            if(end==null) break; //说明已经不足k个直接退出
            ListNode start = pre.next; //子链表的第一个节点
            ListNode next = end.next; //子链表的最后一个节点的下一个节点
            end.next = null; //让最后一个节点的next为Null，模拟出单链表反转的条件
            pre.next = reserve(start);
            start.next = next;  //因为反转后start.next = null，所以要重新连接 
            pre = start;   //因为pre是反转的子链表的上一个
            end = pre; //因为经过反转之后原来的end已经变成了反转后的头节点，所以要移动到正确的位置
        }
        return newHead.next;
    }
    public static ListNode reserve(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //字节跳动面试题，改编版本的k个一组反转
    //上面的k个一组反转是从头结点开始的，不足的节点在尾部
    //字节跳动的题就是从尾节点开始，不足的点在头部
    //简单的思路就是先把原始链表反转，然后进行K个一组反转，最后再反转链表
    //但是还有更加优的方案就是我们去计算链表长度，用长度对K取余，得到的offset就是在头部不足的点的长度，只需要把这部分以外的
    //链表进行k个一组反转，然后再跟头部不足的部分进行连接，就可以得到答案
    public static ListNode reverseK_byteDance(ListNode head){
        return head;
    }
    
    public static void main(String[] args){

    }
}