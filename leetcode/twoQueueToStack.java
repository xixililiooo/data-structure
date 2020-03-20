package leetcode;

import java.util.LinkedList;



public class twoQueueToStack {
        LinkedList<Integer> queue1;
        LinkedList<Integer> queue2;
    public twoQueueToStack(){
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
    }
    public void push(int x){
        /*
            确保数据都在一个队列里
        */
        if(this.queue1.isEmpty()&&this.queue2.isEmpty()){
            this.queue1.offer(x);
        }else if(this.queue1.isEmpty()){
            this.queue2.offer(x);
        }else{
            this.queue1.push(x);
        }
    }
    public int pop(){
        if(this.queue1.isEmpty()&&this.queue2.isEmpty()){
            return 0;
        }
        if(this.queue1.isEmpty()){
           int len = this.queue2.size();
            while(len!=1){
                this.queue1.offer(this.queue2.poll());
                len--;
            }
            return this.queue2.poll();
        }
        if(this.queue2.isEmpty()){
            int len = this.queue1.size();
             while(len!=1){
                 this.queue2.offer(this.queue1.poll());
                 len--;
             }
             return this.queue1.poll();
         }
         return 0;
    }
    public int top(){
        if(this.queue1.isEmpty()&&this.queue2.isEmpty()){
            return 0;
        }
        if(this.queue1.isEmpty()){
           int len = this.queue2.size();
            while(len!=1){
                this.queue1.offer(this.queue2.poll());
                len--;
            }
            Integer last = this.queue2.poll();
            this.queue1.offer(last);
            return last;
        }
        if(this.queue2.isEmpty()){
            int len = this.queue1.size();
             while(len!=1){
                 this.queue2.offer(this.queue1.poll());
                 len--;
             }
             Integer last = this.queue1.poll();
             this.queue2.offer(last);
             return last;
         }
         return 0;
    }
    public Boolean isEmpty(){
        return this.queue1.isEmpty()&&this.queue2.isEmpty()?true:false;
    }

}