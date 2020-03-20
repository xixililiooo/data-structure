package structure.tree;

import java.util.ArrayList;
import java.util.Stack;

public class preOrder {
   /*
        利用栈结构就可以完成前序遍历
   */ 
    public static ArrayList pre(TreeNode head){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(head==null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            result.add(top.val);
            if(top.right!=null)
            stack.push(top.right);
            if(top.left!=null)
            stack.push(top.left);
        }
        return result;
    }
}