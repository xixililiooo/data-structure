package structure.linkList;
//对链表进行partion的操作
public class node_partion {
    //解法一就是把节点放入数组中，然后利用数组的partion来实现

    //进阶版本的要求是实现partion不能破坏相对顺序
    //解决的思路就是整出三个链表，一个是等于部分的，一个是大于部分的，一个是小于部分的
    //然后把三个链表相加就可以得到要求的链表
    public static Node partion(Node head,int pivot){
        Node sH = null;  //小于部分的头节点
        Node sE = null;
        Node eH = null; //等于部分的头节点
        Node eE = null;
        Node lH = null; //大于部分的头结点
        Node lE = null;
        Node next = null;
        while(head!=null){   //循环一次之后就可以得到三部分的链表
            next = head;
            head.next = null;
            if(head.value > pivot){
                if(lH==null){
                    lH = head;
                    lE = head;
                }else{
                    lE.next = head;
                    lE = head;
                }
            }
            if(head.value == pivot){
                if(eH==null){
                    eH = head;
                    eE = head;
                }else{
                    eE.next = head;
                    eE = head;
                }
            }
            if(head.value < pivot){
                if(sH==null){
                    sH = head;
                    sE = head;
                }else{
                    sE.next = head;
                    sE = head;
                }
            }
            head = next;
        }
        //接下来就把三部分的链表重新连接
        if(sH!=null){
            sE.next = eH;
            eH = eH==null?sE:eH;  //为了能连接下去，如果没有等于的节点，要把eH换成sE
        }
        if(eH!=null){
            eE.next = lH;
        }
        return sH!=null?sH:eH!=null?eH:lH;   //返回头部的时候也要作判断
    }
    public static void main(String[] args){

    }
}