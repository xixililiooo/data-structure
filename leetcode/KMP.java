package leetcode;

public class KMP {
    /*
        KMP用于解决在主串中查找子串的问题
        如果存在子串就返回字串开头的位置
        如果不存在就返回-1
        主要思想是在搜索子串的过程中遇到不匹配的不回退，这样就避免了一些重复搜索的过程，提高了搜索的效率
        核心在于next数组的构建
        所谓Next数组，它就是每个字符的最长前后缀
        那什么是最长前后缀，比如  abcabcd，求d的最长前后缀，首先是确定目标，目标就是d字符前面的字符串，也就是abcabc
        我们从前面找跟后面找，相同的前后缀的长度,最长前缀不包括最后一个字符，最长后缀不包括第一个字符
        前面找就是abc，后面找也有abc,所以最长前后缀的长度为3
        再比如aaaaad,求d的最长前后缀，所以目标就是aaaaa，相同的前后缀为aaaa，长度为4
        知道了最长前后缀的概念之后，我们就可以根据动态规划的方式去得到每个字符的最长前后缀
        所谓动态规划就是利用basecase去往上推导
        对于第一个字符，由于它前面没有任何字符，所以它的最长前后缀为-1
        对于第二个字符，由于它前面只有一个字符，所以它前面的字符只有一个，但是前缀不包括最后一个，所以它的最长前后缀为0

    */
    public static int[] getNext(String str2){
        int len = str2.length();
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while(index<len){
            if(str2.charAt(index-1) == str2.charAt(cn)){
                next[index++] = ++cn;
            }
            else if(cn > 0) cn = next[cn];
            else{
                next[++index] = 0;
            }
        }
        return next;
    }
    public static int solution(String main_str,String sub_str){
        int[] next = getNext(sub_str);  //得到next数组
        int i = 0;
        int j = 0;
        int main_len = main_str.length();
        int sub_len = sub_str.length();
        while(i<main_len && j<sub_len){
            if(main_str.charAt(i) == sub_str.charAt(j)){  //如果相等就一起往下走
                i++;
                j++;
            }else if(next[j]==-1) i++;
            else j = next[j];
        }
        return j==sub_len?i-j:-1;
    }
    public static void main(String[] args){

    }
}