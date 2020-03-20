package structure.linkList;
/*
    删除单链表倒数第k个节点
    删除双链表倒数第k个节点
*/
public class deteleKthNode {
    //单链表方法一
    public static Node deleteNode(Node header,int k){
        Node cur = header;
        while(header!=null){
            k--;
            cur = cur.next;
        }
        if(k==0){
            header = header.next;
        }
        if(k<0){
            cur = header;
            while(++k!=0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return header;
    }
    //单链表方法二
    public static Node deleteNodeOther(Node header,int k){
        Node fast = header;
        Node slow = header;
        while(k!=0){
            fast = fast.next;
            k++;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return header;
    }
    //双链表方法
    public static Node deleteDoubListNode(Node header,int k){
        Node cur = header;
        while(cur!=null){
            k--;
            cur = cur.next;
        }
        if(k==0){
            header = header.next;
        }
        if(k<0){
            cur = header;
            while(++k!=0){
                cur = cur.next;
            }
            Node newNode = cur.next.next;
            cur.next = newNode;
            if(newNode!=null){  //确保这个节点存在，否则会报错
                newNode.last = cur;
            }
        }
        return header;
    }
    public static void main(String[] args){
        
    }
}