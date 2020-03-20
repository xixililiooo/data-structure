package leetcode;

import sun.util.logging.resources.logging;

public class findKthMaxNum {
    /*
        两个有序数组，得到他们合并后的第k大的数
    */
    public static int getKth(int[] arr1,int[] arr2,int k){
        /*
            两个数组的长度可能一长(long)一短(short)，可能相同
            分三种情况：
            1.k比最短的还要小，那就两个数组都取k长度
            2.k>long  long数组中前面k-short的都不可能，short数组中前面k-long都不可能
            3. short<k<long，long数组中前面long-k和倒数的long-k都不可能
        */
        int[] longArr = arr1.length>=arr2.length?arr1:arr2;
        int[] shortArr = arr1.length>=arr2.length?arr2:arr1;
        int l = longArr.length;
        int s = shortArr.length;
        if(k<=s){  //情况一
            return getupFind(shortArr, 0, k-1, longArr, 0, k-1);
        }
        if(k>l){  //情况二
            if(shortArr[k-l-1]>=longArr[l-1]){
                return shortArr[k-l-1];
            }
            if(longArr[k-s-1]>=shortArr[s-1]){
                return longArr[k-s-1];
            }
            return getupFind(shortArr, k-l, s-1, longArr, k-s, l-1);
        }
        //接下来的情况就是  s<k<l ：情况三
        if(longArr[k-s-1]>=shortArr[s-1]){
            return longArr[k-s-1];
        }
        return getupFind(shortArr, 0, s-1, longArr, k-s, l-k);
    }
    /*
        给定两个相同大小的有序数组，找出他们的上中位数
    */
    public static int getupFind(int[] arr1,int s1,int e1,int[] arr2,int s2,int e2){
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0; 
        while(s1<e1){
            offset = ((e1-s1+1)&1)^1;  //长度为双数偏移值为1
            mid1 = (s1+e1)/2;
            mid2 = (s2+e2)/2;
            if(arr1[mid1]>arr2[mid2]){
                e1 = mid1;
                s2 = mid2+offset;
            }else if(arr1[mid1]<arr2[mid2]){
                s1 = mid1+offset;
                e2 = mid2;
            }else{
                return arr1[mid1];
            }
        }
        return Math.min(arr1[s1],arr2[s2]);
    }
    public static void main(String[] args){
        int[] arr1 = new int[]{1,4,7,100,200};
        int[] arr2 = new int[]{2,7,18,45,60,300};
        System.out.print(getKth(arr1, arr2, 7));
    }
}