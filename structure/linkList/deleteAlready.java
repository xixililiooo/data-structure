package structure.linkList;

import java.util.HashSet;

/*
    删除单链表中值重复的节点
*/
public class deleteAlready{

    /*
        时间复杂度和空间复杂度都为o(n)的解法
    */
    public void Solution(ListNode head){
        if(head==null) return;
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode cur = head.next;
        ListNode pre = head;
        set.add(head.val);
        while(cur!=null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
            }else{
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }

}