package structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class serialByPre {
    public static String serial(TreeNode head){
        if(head==null){
            return "#!";
        }
        String str = head.val+"!";

        str+=serial(head.left);
        str+=serial(head.right);
        return str;
    }
    public static TreeNode reBuild(String str){
        String[] serialArr = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0;i<serialArr.length;i++){
            queue.offer(serialArr[i]);
        }
        TreeNode head = reBuildPreOrder(queue);
        return head;
    }
    public static  TreeNode reBuildPreOrder(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reBuildPreOrder(queue);
        head.right = reBuildPreOrder(queue);
        return head;
    }
    public static void main(String[] args){
        String str = "12!3!#!#!#!";
        TreeNode head = reBuild(str);
        String serialStr = serial(head);
        System.out.print(serialStr);
    }
}