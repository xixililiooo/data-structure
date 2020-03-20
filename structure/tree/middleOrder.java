package structure.tree;

import java.util.ArrayList;
import java.util.Stack;

public class middleOrder {
    public static ArrayList middle(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            result.add(top.val);
            cur = top.right;
        }
        return result;
    }
}