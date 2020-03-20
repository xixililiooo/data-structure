public class PostArray{
    public static boolean isPostArray(TreeNode head){
        if(head==null) return true;
    }
    public static boolean isPost(int [] arr,int start,int end){
        int less = -1;
        int more = end;
        for(int i = start;i<end;i++){
            if(arr[end]>arr[i]){
                less = i;
            }else{
                more = more==end?i:more;
            }
        }
        if(less==-1 || more ==end){
            return isPost(arr, start, end-1);
        }
        if(less!=more-1){
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end-1);
    }
}