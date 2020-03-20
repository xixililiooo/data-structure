package leetcode;

import java.util.LinkedList;

public class getMaxWindow {
    public static void Solution(int[] arr, int w) {
        if (arr.length < w || w < 1)
            return;
            //双端队列
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //存储结果的数组
        int[] res = new int[arr.length - w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 头[]尾
            //从尾部判断，判断当前要加进来的值能比队列里多少个值要大，干掉他们
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            //把自己加进去
            qmax.addLast(i);
            //如果队首的下标值已经过期，就把队首弹出
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            //判断是否可以存储结果了
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] { 4, 3, 5, 4, 3, 3, 6, 7 };
        Solution(test, 3);
    }
}