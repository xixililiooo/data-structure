package structure.tree;

//把一棵树的边界按照两个规则进行打印
public class printEdgel{
    public static void print1(TreeNode head){
        if(head==null) return;
        int height = getHeight(head);
        TreeNode[][] leftRightMap = new TreeNode[height][2];
        setLeftRightNode(head,0,leftRightMap);  //得到每一层的最左节点和最右节点
        //先把最左的节点输出
        for(int i = 0;i<leftRightMap.length;i++){
            System.out.println(leftRightMap[i][0].val);
        }
        //接下来就打印整棵树中非最左也非最右的叶子节点
        printNotLeftAndNotRight(head,0,leftRightMap);
        //最后打印整棵树中最右的节点
        for(int i = leftRightMap.length-1;i>=0;i--){
            if(leftRightMap[i][0]!=leftRightMap[i][1]){  //确保最左的节点和最右的节点不是同一个，避免重复打印
                System.out.println(leftRightMap[i][1].val);
            }
        }
    }
    public static int getHeight(TreeNode head){
        if(head==null) return 1;
        return Math.max(getHeight(head.left),getHeight(head.right))+1;
    }
    public static void setLeftRightNode(TreeNode head,int h,TreeNode[][] leftRightMap){
        if(head==null) return;
        leftRightMap[h][0] = leftRightMap[h][0]==null?head:leftRightMap[h][0];
        leftRightMap[h][1] = head;
        setLeftRightNode(head.left, h+1, leftRightMap);
        setLeftRightNode(head.right, h+1, leftRightMap);
    }
    public static void printNotLeftAndNotRight(TreeNode head,int h,TreeNode[][] leftRightMap){
        if(head==null) return;
        if(head.left==null && head.right==null && head!=leftRightMap[h][0] && head!=leftRightMap[h][1]){
            System.out.println(head.val);
        }
        printNotLeftAndNotRight(head.left, h+1, leftRightMap);
        printNotLeftAndNotRight(head.right, h+1, leftRightMap);
    }
    public static void main(String[] args){

    }
}