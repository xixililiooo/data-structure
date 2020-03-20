package structure.linkList;

public class deleteMiddleNode {
    /*
        找到链表中间的节点
        双指针法：设置一个快指针和一个慢指针
    */
    public static Node getMiddleNode(Node header){
        if(header==null || header.next==null || header.next.next==null){
            return header;
        }
        Node fast  = header.next.next;
        Node slow = header.next;
        while(fast.next!=null){
            if(fast.next.next==null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //反转链表
    public static Node reverseList(Node header){
        Node cur = header;
        Node pre = null;
        while(cur!=null){
            Node next = cur.next;
            next.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //反转部分单向链表
    //把链表中from到to部分的链表进行反转操作
    public static Node partReverseList(Node head,int from,int to){
        //先找到from的前一个节点和to的后面一个节点
        Node cur = head;
        int len = 0;
        Node pre = null;
        Node next = null;
        while(cur!=null){
            len++;
            pre = from-1==len?cur:pre;
            next = to+1==len?cur:next;
            cur = cur.next;
        }
        //开始过滤条件
        if(from>to || from < 1 || to>from){
            return head;
        }
        Node start  = pre==null?head:pre.next;
        cur = start;
        Node preNode = next;
        while(cur!=next){
            Node nextNode = cur.next;
            cur.next = preNode;
            cur = nextNode;
            preNode = cur;
        }
        if(pre==null){  //如果是从头部开始反转，就返回最后的preNode就行
            return preNode;
        } 
        //如果不是从头部开始反转，那就把from的前一个节点连接好然后返回head
        pre.next = preNode;
        return head;
    }
    public static void main(String[] args){

    }
}