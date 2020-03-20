package leetcode;

import java.util.HashMap;
/*
    如果一个数组有整数负数和0,求累加和为k的最长子数组的长度
*/
public class getAllLongestSubArray {
    public static int Solution(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int res = 0;  //子数组的最长长度
        int sum = 0;  //累加和
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            int target = sum - k;
            if(map.containsKey(target)){
                int start = map.get(target);
                res = Math.max(res,i-start);
            }else{
                map.put(i,sum);
            }
        }
        return res;
    }
    public static void main(String[] args){
        
    }
}