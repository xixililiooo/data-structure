public class contains{
    //
    public static Boolean contain(TreeNode t1,TreeNode t2){
        return check(t1,t2) || check(t1.left,t2) || check(t1.right,t2);
    }
    public static Boolean check(TreeNode t1,TreeNode t2){
        if(t2==null) return true;
        if(t1==null || t1.val != t2.val){
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }
}