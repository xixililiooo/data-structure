package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    LinkedList<Integer> dataQueue;
    LinkedList<Integer> maxQueue;
    public MaxQueue() {
        dataQueue = new LinkedList<Integer>();
        maxQueue = new LinkedList<Integer>();
    }
    
    public int max_value() {
         if(maxQueue.isEmpty()){
            return -1;
        }
        return maxQueue.peekFirst();
    }
    
    public void push_back(int value) {
            dataQueue.addFirst(value);
            while(!maxQueue.isEmpty()&&maxQueue.peekLast()<value){
                maxQueue.pollLast();
            }
            maxQueue.addLast(value);
    }
    
    public int pop_front() {
        if(maxQueue.isEmpty()){
            return -1;
        }
        int result = dataQueue.pollLast();
        if(result==maxQueue.peekFirst()){
            maxQueue.pollFirst();
        }
        return result;
    }
    
}