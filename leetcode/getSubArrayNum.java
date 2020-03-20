package leetcode;


import java.util.LinkedList;

/*
    给定数组arr和整数num，共返回多少个子数组符合如下情况:
    max(arr[i...j]) - max(arr[i...j]) <=num
    max(arr[i...j])表示子数组arr[i...j]中的最大值

    思路:维护两个窗口，一个窗口用于得到最大值，一个窗口用于得到最小值，同步更新窗口
    如果 循环到arr[i...j]不符合条件，那么 arr[i..j-1]是以i开头的且符合条件的子数组，数量是 j-i
    且arr[i...j]之后以i开头的子数组都不符合条件那就直接跳过，判断以[i+1...j]以后的子数组是否符合条件
*/
public class getSubArrayNum {
    public static int getNum(int[] arr,int num){
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < arr.length){
            while(j < arr.length){
                while(!qmax.isEmpty() && arr[qmax.peekFirst()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(i);
                while(!qmin.isEmpty() && arr[qmin.pollFirst()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(i);
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            res+=j-1;
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        
    }
}