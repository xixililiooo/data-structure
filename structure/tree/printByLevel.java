package structure.tree;

import java.util.LinkedList;
import java.util.Queue;
/*
    对于一棵树，输出的结构为
    Level1:3 
    Level2:9 20 
    Level3:15 7 
*/
public class printByLevel {
    public static void print(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode last = head;
        TreeNode nlast = null;
        int level = 1;
        queue.offer(head);
        System.out.print("Level"+(level++)+":");
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.offer(node.left);
                nlast = node.left;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nlast = node.right;
            }
            if(node==last && !queue.isEmpty()){
                System.out.print("\nLevel"+(level++)+":");
                last = nlast;
            }
        }
    }
    public static void main(String[] args){

    }
}