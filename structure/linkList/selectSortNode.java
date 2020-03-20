package structure.linkList;

public class selectSortNode {
    public static ListNode solution(ListNode head){
        /*
            实现链表的选择排序
            首先要做的就是记录排序部分的尾节点tail和未排序部分的头结点cur
            然后每次从未排序的部分选出最小的节点min并且删除它，想要实现删除操作，就要记录最小节点的前一个节点preMin
            把删除的节点添加到tail的next
        */
        ListNode tail = null;
        ListNode cur = head;
        ListNode preMin = head;
        ListNode min = null;
        while(cur!=null){
            min = cur;
            preMin = getPreMinNode(cur);
            if(preMin!=null){  //最小值的节点不是头部节点
                min = preMin.next;
                preMin.next = min.next;
            }
            cur = cur==min?cur.next:cur;
            if(tail==null){
                head = min;
            }else{
                tail.next = min;
            }
            tail = min;
        }
        return head;
    }
    public static ListNode getPreMinNode(ListNode head){
        ListNode cur = head.next;
        ListNode preMin = head;
        ListNode min = head;
        ListNode pre = head;
        while(cur!=null){
            if(cur.val<min.val){
                preMin = pre;
                min = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return preMin;
    }
    public static void main(String[] args){

    }
}