package leetcode;
//求最长的递增子序列
import java.lang.reflect.Array;
import java.util.Arrays;

public class longestIncreasingSub{
    public static int getSub(int[] arr){
        if(arr.length==0) return 0;
        int res = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(arr,1);
        for(int i = 1;i<arr.length;i++){
            for(int j = i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}