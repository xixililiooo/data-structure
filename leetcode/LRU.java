package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
    public static class Node{
        Node next;
        Node last;
        int value;
        public Node(int value){
            this.next = null;
            this.last = null;
            this.value = value;
        }
    }
    public static class linkedList{
        Node head;
        Node tail;
        public linkedList(){
            this.head = null;
            this.tail = null;
        }
        //定义一个添加节点的方法
        public void addNode(Node newNode){
            if(newNode == null){
                return;
            }
            if(this.head == null){
                this.head = newNode;
                this.tail = newNode;
            }
            else{
                Node tail = this.tail;
                tail.next = newNode;
                newNode.last = tail;
                this.tail = newNode;
            }
        }
        //定义一个把节点添加到尾部的方法
        public void moveNodeToTail(Node node){
            if(this.tail == node){
                return;
            }
            if(this.head == node){
                this.head = node.next;
                this.head.last = null;
            }
            else{
                node.next.last = node.last;
                node.last.next = node.next;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }
        //定义一个删除头结点的方法
        public Node removeHead(){
            if(this.head == null){
                return null;
            }else if(this.head == this.tail){
                this.head = null;
                this.tail = null;
                return null;
            }
            else{
                Node head = this.head;
                this.head = this.head.next;
                this.head.last = null;
                head.last = null;
                return head;
            }
            
        }
    }
    public static class LRUCache{
        HashMap<Integer,Node> nodeMap; 
        HashMap<Node,Integer> KeyMap;
        int size;
        linkedList linkedlist;
        public LRUCache(Integer size){
            this.nodeMap = new HashMap<Integer,Node>();
            this.KeyMap  = new HashMap<Node,Integer>();
            this.linkedlist = new linkedList();
            this.size = size;
        }
        public void set(Integer key,int value){
            //如果设置的值已经存在过，就更改值然后把对应的节点移动到尾部
            if(this.nodeMap.containsKey(key)){
                Node node = this.nodeMap.get(key);
                node.value = value;
                this.linkedlist.moveNodeToTail(node);
            }else{  //如果设置的值还没设置过，就创建对应的节点添加到双端队列的尾部
                Node newNode = new Node(value);
                this.linkedlist.addNode(newNode);
                this.nodeMap.put(key,newNode);
                this.KeyMap.put(newNode,key);
                if(this.nodeMap.size() == this.size+1){  //说明此时已经到达缓存的界限，需要把头部的节点移除，因为头部是最不常使用的
                    Node deleteNode = this.linkedlist.removeHead();
                    Integer deleteKey = this.KeyMap.get(deleteNode);
                    this.nodeMap.remove(deleteKey);
                    this.KeyMap.remove(deleteNode);
                }
            }
        }
        public int get(Integer key){ //除了要返回对应key的值，也要把对应的节点移动到尾部
            if(this.nodeMap.containsKey(key)){
                Node node = this.nodeMap.get(key);
                this.linkedlist.moveNodeToTail(node);
                return node.value;   
            }
            return -1;
        }
    }
    public static void main(String[] args){
        LRUCache testCache = new LRUCache(3);
        // testCache.set("A", 1);
		// testCache.set("B", 2);
		// testCache.set("C", 3);
		// System.out.println(testCache.get("B"));
		// System.out.println(testCache.get("A"));
		// testCache.set("D", 4);
		// System.out.println(testCache.get("D"));
		// System.out.println(testCache.get("C"));

    }
}