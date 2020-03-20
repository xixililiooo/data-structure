package structure.tree;

import java.util.HashMap;

public class getMaxLength {
    public static int getLength(TreeNode head,int sum){
        HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        sumMap.put(0,0);
        return preOrder(head,sum,0,1,0,sumMap);
    }
    public static int preOrder(TreeNode head,int sum,int preSum,int level,int maxLen,HashMap<Integer,Integer> sumMap){
        if(head==null){
            return maxLen;
        }
        int curSum = preSum + head.val;
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if(sumMap.containsKey(curSum-sum)){
            maxLen = Math.max(level-sumMap.get(curSum-sum),maxLen);
        }
        maxLen = preOrder(head.left, sum, curSum, level+1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level+1, maxLen, sumMap);
        if(level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }
    public static void main(String[] args){

    }
}