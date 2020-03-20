package leetcode;
/*
    在单链表中删除任意一个节点
*/
public class Leetcode18 {
    public ListNode deleteNode(ListNode head, int val){
        if(head==null) return head;
        if(head.val == val){  //考虑是头节点的情况
            head = head.next;
            return head;
        }
        int count = 0; //根据count回溯到前驱节点
        ListNode preHead = head;
        ListNode curHead = head;
        while(curHead.val != val && curHead.next != null){
            curHead = curHead.next;
            count++;
        }
        while(count>=2){
            preHead = preHead.next;
            count--;
        }
        if(curHead.next == null){ //考虑是尾节点的情况
            preHead.next = null;
        }else{
            preHead.next = preHead.next.next;
        }
        return head;
    }
    public static void main(String[] args){
        
    }
}