package leetcode;

import java.util.HashMap;

import sun.util.logging.resources.logging;

public class LFU {
    //LFU缓存主要利用了一个二维的双向链表
    //主要是根据对数据的操作频率来对数据进行更改
    public static class Node{  //单个节点的结构
        int key;
        int value;
        Node up;
        Node down;
        int times;
        public Node(int key,int value,int times){
            this.key = key;
            this.value = value;
            this.times = times;
            this.down = null;
            this.up = null;
        }
    }
    public static class nodeList{  //noedList就是横向双向列表的单位
        Node head;
        Node tail;
        nodeList last;
        nodeList next;
        public nodeList(Node head){
            this.head = head;
            this.tail = head;
            this.last = null;
            this.next = null;
        }
        //定义一个从头部添加的方法
        public void addFromHead(Node node){
            if(node == null){
                return;
            }
            else{
                node.down = this.head;
                this.head.up = node;
                this.head = node;
            }
        }
        //定义一个删除节点的方法
        public void deleteNode(Node node){
            if(node == null) return;
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
                return;
            }
            if(node == this.head){
                this.head = node.down;
                this.head.up = null;
            }else if(node == this.tail){
                this.tail = node.up;
                this.tail.down = null;
            }else{
                node.up.down = node.down;
                node.down.up = node.up;
            }
            node.up = null;
            node.down = null;
        }
        //定义一个判断nodeList是否为空的方法
        public Boolean isEmpty(){
            return this.head == null;
        }
    }
    public static class lfuCache{
        int size;
        int capacity;
        nodeList firstNodeList;
        HashMap<Integer,Node> records;
        HashMap<Node,nodeList> nodeListMap;
        public lfuCache(int capacity){
            this.size = 0;
            this.capacity = capacity;
            this.firstNodeList = null;
            this.records = new HashMap<Integer,Node>();
            this.nodeListMap = new HashMap<Node,nodeList>();
        }
        public void set(int key,int value){
            if(this.records.containsKey(key)){
                Node node = this.records.get(key);
                nodeList nodelist = this.nodeListMap.get(node);
                node.times++;
                node.value = value;
                this.move(node, nodelist);
            }else{ //如果是记录里面没有
                if(this.capacity==0) return;
                if(this.size == this.capacity){  //如果存储容量满了
                    Node deleteNode = this.firstNodeList.tail;
                    this.firstNodeList.deleteNode(deleteNode);
                    this.modifyNodeList(this.firstNodeList);
                    this.records.remove(deleteNode.key);
                    this.nodeListMap.remove(deleteNode);
                    this.size--;
                }
                Node newNode = new Node(key,value,1);
                if(this.firstNodeList==null){
                    this.firstNodeList = new nodeList(newNode);
                }
                else if(this.firstNodeList.head.times == newNode.times){
                    this.firstNodeList.addFromHead(newNode);
                }else{
                    nodeList newNodeList = new nodeList(newNode);
                    newNodeList.next = this.firstNodeList;
                    this.firstNodeList.last = newNodeList;
                    this.firstNodeList = newNodeList;
                }
                this.records.put(key,newNode);
                this.nodeListMap.put(newNode,this.firstNodeList);
                this.size++;
            }
        }
        public int get(int key){
            if(this.records.containsKey(key)){
                Node node = this.records.get(key);
                nodeList nodelist= this.nodeListMap.get(node);
                node.times++;
                this.move(node,nodelist);
                return node.value;
            }
            return -1;
        }
        //定义一个函数，其包含的功能就是把node节点从oldNodeList中删除掉并且把node插入到正确的nodeList中
        public void move(Node node,nodeList oldNodeList){
            //先把节点从oldNodeList中删除点
            oldNodeList.deleteNode(node);
            //判断删除后的nodelist是否为空
            nodeList lastNodeList = modifyNodeList(oldNodeList)?oldNodeList.last:oldNodeList;
            nodeList nextNodeList = oldNodeList.next;
            if(nextNodeList!=null){  //
                if(nextNodeList.head.times == node.times){
                    nextNodeList.addFromHead(node);
                    this.nodeListMap.put(node,nextNodeList);
                }else{
                    nodeList newNodeList = new nodeList(node);
                    this.nodeListMap.put(node,newNodeList);
                    if(lastNodeList !=null){
                        lastNodeList.next = newNodeList;
                    }
                    nextNodeList.last = newNodeList;
                    newNodeList.last = lastNodeList;
                    newNodeList.next = nextNodeList;
                    if(this.firstNodeList == nextNodeList){
                        this.firstNodeList = newNodeList;
                    }
                }
            }else{  //如果这个nodeList是最后一个
                nodeList newNodeList = new nodeList(node);
                if(lastNodeList!=null){
                    lastNodeList.next = newNodeList;
                }
                newNodeList.last = lastNodeList;
                if(this.firstNodeList == null){
                    this.firstNodeList = newNodeList;
                }
                this.nodeListMap.put(node, newNodeList);
            }
        }
        //定义一个函数，其功能就是判断nodelist是否为空，如果nodelist为空就删除掉他，然后返回true,如果不为空就返回false
        public Boolean modifyNodeList(nodeList nodelist){
                if(nodelist.isEmpty()){
                    if(this.firstNodeList == nodelist){
                        this.firstNodeList = this.firstNodeList.next;
                        if(this.firstNodeList != null){
                            firstNodeList.last = null;
                        }
                    }else{
                        if(nodelist.next != null){
                            nodelist.next.last = nodelist.last;
                        }
                         nodelist.last.next = nodelist.next;
                    }
                }   
                return false;
        }
    }
    public static void main(String[] args){

    }
}