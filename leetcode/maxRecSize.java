package leetcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class maxRecSize {
    public static int maxRecFromBottom(int[] height) {
        if (height.length == 0)
            return 0;
        int length = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int maxHeight = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                int currentHeight = (i - stack.peek()) * height[top];
                maxHeight = Math.max(currentHeight, maxHeight);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int currentHeight = (length - 1 - stack.peek()) * height[top];
            maxHeight = Math.max(currentHeight, maxHeight);
        }
        return maxHeight;
    }

    public static int getmaxResSize(int[][] map) {
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == '0' ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }

    public static void main(String[] args){
        // Scanner scanner = new Scanner(System.in);
        // ArrayList result = new ArrayList();
        // int index = 0;
        // while(true){
        //     String nextLine = scanner.nextLine();
        //     String[] item = nextLine.trim().split(" ");
        //     result.add(item);
        //     if(nextLine == null || nextLine.trim().length() == 0) {
        //         System.out.println("empty, break");
        //         break;
        //     }
        // }
        // Object[] item = result.toArray();
        // for(int i = 0;i<item.length;i++){
        //     for(int j = 0;j<item[0];j++){
        //         System.out.println(item)
        //     }
        // }

    

    }
}