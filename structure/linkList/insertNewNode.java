package structure.linkList;

public class insertNewNode {
    public static ListNode insert(ListNode head,int val){
        ListNode newNode = new ListNode(val);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur!=head){
            if(pre.val<=val && cur.val>=val){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return head.val > val ? newNode : head;
    }
}