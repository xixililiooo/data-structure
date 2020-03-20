package structure.tree;

/*
    实现morrisIn前序遍历，就是把第一次到某个节点的时候进行输出操作
    前序遍历就是当第一次来到这个节点的时候就进行输出操作
    中序遍历就是当第二次来到这个节点的时候就进行输出操作
    如果一个节点没有左节点，那么这个节点在整个遍历过程中只会来到这个节点一次
*/
public class morrisIn{
    public static void morris(TreeNode head){
        TreeNode cur = head;
        TreeNode mostRight = null;
        while(cur!=null){
            mostRight = cur.left; //先拿出节点的左节点，如果为空那就往右边走，如果有左节点，找到左节点的最右节点
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                        mostRight.right = cur;
                        //第一次来到这个节点
                        System.out.println(cur.val);
                        cur = cur.left;
                        continue;
                }else{
                    //否则就是第二次来到这个节点
                    mostRight.right = null;
                }
            }else{
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }
    public static void main(String[] args){

    }
}