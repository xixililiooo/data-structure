import java.util.LinkedList;
import java.util.Queue;
/*
    [1,2,3,4,null,5,6,null,null,7,8,null,null]
    zigzag打印结果如下：
    level 1 from left to right : 1
    level 2 from right to left :3 , 2
    level 3 from left to right : 4 , 5 ,6
    level 4 from right to left : 8 7

*/
public class printByZigZag {
    public static void zigzag(TreeNode head){
        LinkedList<TreeNode> dq = new LinkedList<TreeNode>();
        boolean lr = true;
        int level = 1;
        TreeNode last = head;
        TreeNode nlast = null;
        dq.addLast(head);
        printLOfR(level++, lr);
        while(!dq.isEmpty()){
            if(lr){
                head = dq.pollFirst();
                if(head.left!=null){
                    nlast = nlast==null?head.left:nlast;
                    dq.addLast(head.left);
                }
                if(head.right!=null){
                    nlast = nlast==null?head.right:nlast;
                    dq.addFirst(head.right);
                }
            }else{
                head = dq.pollLast();
                if(head.right!=null){
                    nlast = nlast==null?head.right:nlast;
                    dq.addFirst(head.right);
                }
                if(head.left!=null){
                    nlast = nlast==null?head.left:nlast;
                    dq.addFirst(head.left);
                }
            }
            System.out.print(head.val+" ");
            if(head==last){
                last = nlast;
                lr = !lr;
                nlast = null;
                System.out.println();
                printLOfR(level++, lr);
            }
        }
    }
    public static void printLOfR(int level,Boolean lr){
        System.out.print("level" + level + "from ");
        System.out.print(lr?"left to right":"right to left");
    }
}