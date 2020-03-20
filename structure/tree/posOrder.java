package structure.tree;

import java.util.ArrayList;
import java.util.Stack;

public class posOrder {
    public static ArrayList pos(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode top = stack1.pop();
            stack2.push(top);
            if(top.left!=null) stack1.push(top.left);
            if(top.right!=null) stack1.push(top.right);
        }
        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        return result;
    }
}