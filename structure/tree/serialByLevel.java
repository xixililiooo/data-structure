package structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
    通过层次遍历实现二叉树的序列化与反序列化
    层次遍历通过队列实现
*/
public class serialByLevel {
    public static String serail(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        String str = head.val+"!";
        queue.offer(head);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left!=null){
                queue.offer(cur.left);
                str+=cur.left.val+"!";
            }else{
                str+="#!";
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                str+=cur.right.val+"!";
            }else{
                str+="#!";
            }
        }
        return str;
    }
    public static TreeNode reBuild(String str){
        String[] serialArr = str.split("!");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode head = generateNodeByString(serialArr[index++]);
        if(head!=null) queue.offer(head);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            cur.left = generateNodeByString(serialArr[index++]);
            cur.right = generateNodeByString(serialArr[index++]);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }   
        }
        return cur;
    }
    public static TreeNode generateNodeByString(String val){
        if(val.equals("#")){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
    public static void main(String[] args){

    }
}