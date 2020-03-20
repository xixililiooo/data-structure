package structure.tree;

public class biggestSubBST {

    public static TreeNode getBST(TreeNode head){
        int[] record = new int[3];
        return posOrder(head,record);
    }
    public static void main(String[] args){

    }
    public static TreeNode posOrder(TreeNode head,int[] record){
        if(head==null){
            record[0] = 0;   //节点个数
            record[1] = Integer.MAX_VALUE;  //最小值
            record[2] = Integer.MIN_VALUE; //最大值
            return null;  //头结点
        }
        int value = head.val;
        TreeNode left = head.left;
        TreeNode right = head.right;
        TreeNode lBST = posOrder(head.left, record);
        int lSize =  record[0];
        int lMin = record[1];
        int lMax = record[2];
        TreeNode rBST = posOrder(head.right, record);
        int rSize =  record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin,value);
        record[2] = Math.max(rMax,value);
        if(left==lBST && right==rBST && lMax<value && rMin > value){
            record[0] = lSize+rSize+1;
            return head;
        }
        record[0] = lSize>=rSize?lSize:rSize;
        return lSize>=rSize?lBST:rBST;
    }

}