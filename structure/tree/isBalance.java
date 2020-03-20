package structure.tree;

public class isBalance {
    public static Boolean isBalanced(TreeNode root){ //总的调度函数
        if(root==null) return true;
        return isB(root)&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public static boolean isB(TreeNode root){  //判断以这个节点为头的树是否是根节点
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight-rightHeight)<=1;
    }
    public static int getHeight(TreeNode root){ //定义一个求高度的函数
        if(root==null) return 1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }
}