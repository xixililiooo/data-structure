package structure.linkList;

public class insertSortNode {
    public static ListNode solution(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode cur = head.next;
        ListNode tail = head;
        ListNode pre = head;
        while(cur!=null){
            pre.next = cur.next;  //首先取出cur元素
            insertNode(pre.next,cur,head);
            cur = pre.next;  
        }
        return pre;
    }
    public static void insertNode(ListNode end,ListNode target,ListNode head){
        /*
            将一个节点插入到已经排好序那部分的链表中
        */
        ListNode newHead = head;
        ListNode pre = null;
        while(newHead!=end){
            if(target.val<newHead.val && newHead == head){
                target.next = newHead;
                head = target;
                break;
            }else if(target.val<newHead.val){
                pre.next = target;
                target.next = newHead;
            }
            pre = newHead;
            newHead = newHead.next;
        }
    }
}