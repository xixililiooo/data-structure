package structure.tree;

import java.util.Stack;
/*
    中序遍历之后找到错误的两个节点然后交换他们的值
*/
public class modifyBST {
    public static TreeNode[] modify(TreeNode head){
        /*
            二叉搜索树的中序遍历为有序
        */
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = head;
        TreeNode pre = null;
        TreeNode[] result = new TreeNode[2];
        while(!stack.isEmpty() || cur!=null){
           while(cur!=null){
               stack.push(cur);
               cur = cur.left;
           }
           head = stack.pop();
           if(pre!=null){
                result[0] = pre.val > head.val?pre:result[0];
                result[1] = head;
           }
           pre = head;
           head = head.right;
        }
        return result;
    }
}