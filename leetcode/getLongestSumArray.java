package leetcode;

/*
    数组中全部为整数，求累加和为k的最长子数组
*/
public class getLongestSumArray {
    public static int Solution(int[] arr,int k){
        if(arr.length == 0){
            return 0;
        }
        int l = 0;
        int r = 0;
        int res = 0;
        int sum = arr[0];
        while(r<arr.length){
            if(sum == k){
                res = Math.max(res,r-l+1);
                sum -= arr[l++];
            }else if(sum < k){
                r++;
                if(r == arr.length){
                    break;
                }
                sum += arr[r];
            }else{
                sum -= arr[l++];
            }
        }
        return res;
    }
    public static void main(String[] args){
        
    }
}