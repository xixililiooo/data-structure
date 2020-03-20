package leetcode;
/*
    给定数组arr和k，数组元素有正数负数和0
    求数组中累加和小于等于k的最长子数组
*/
public class getLongestLessSumArray {
    public static int Solution(int[] arr,int k){
        int length = arr.length;
        int[] minSum = new int[length]; //以i位置开头子数组的中的最小值
        int[] minSumEnd = new int[length]; //以i位置开头的子数组最小值的时候对应的右边界
        int end = 0; 
        int res = 0;
        int sum = 0;
        minSum[length-1] = arr[length-1];
        minSumEnd[length-1] = length-1;
        for(int i = length-2;i>=0;i--){
            minSum[i] = minSum[i+1]<=0?arr[i]+minSum[i+1]:arr[i];
            minSumEnd[i] = minSum[i+1]<=0?minSumEnd[i+1]:i;
        }
        for(int i = 0;i<length;i++){
            while(end < length && sum + minSum[end] <=k){  //以0结尾往右扩
                sum += minSum[end];
                end = minSumEnd[end] + 1;
            }
            //扩不动就保存子数组长度
            res = Math.max(res,end - i);
            if(end > i){  //开始左边也往右扩，尝试寻找更长的子数组长度
                sum -= arr[i];
            }else{ //当窗口内没有值了，说明此时sum已经减到0了
                //而0+minSum[end] > k，说明以end位置开头的子数组都不可能了
                //所以直接从以end+1位置开头重新开始寻找最长子数组
                end = i+1;
            }
        }
        return res;
    }
    public static void main(String[] args){

    }
}