package leetcode;

/*
    都是利用了宏观调用打印函数的思想
*/
public class matrixCircle {
    /*
        col1,row1：左上角点的横纵坐标
        col2,row2:右下角的横纵坐标
    */
    //定义一个函数，用于把左上角和右下角所构成的环打印出来
    public static void circle(int col1,int row1,int col2,int row2,int[][] matrix){
        int minRow = row1;
        int minCol = col1;
        while(col1<col2){
            System.out.print(matrix[row1][col1++]);
        }
        while(row1<row2){
            System.out.print(matrix[row1++][col1]);
        }
        while(col2>minCol){
            System.out.print(matrix[row2][col2--]);
        }
        while(row2>minRow){
            System.out.print(matrix[row2--][col2]);
        }
    }
    //定义一个函数把两个点按照斜线打印出来
    public static void matrixZ(int col1,int row1,int col2,int row2,int[][] matrix){
        while(row1<=row2){
            System.out.print(matrix[row1++][col1--]);
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[5][3];
        for(int j = 0;j<matrix.length;j++){
            int[] item = new int[]{1,2,3};
            matrix[j] = item;
        }
        int col1 = 0;
        int row1 = 0;
        int col2 = 0;
        int row2 = 0;
        int maxRow = matrix.length-1;
        int maxCol = matrix[0].length-1;
        // System.out.print(col2);
        // while(row1<=row2){
        //     circle(col1++, row1++, col2--, row2--, matrix);
        // }

        while(row1<=maxRow){
            matrixZ(col1, row1, col2, row2, matrix);
            row1 = col1==maxCol?row1+1:row1;
            col1 = col1==maxCol?maxCol:col1+1;
            col2 = row2==maxRow?col1+1:col1;
            row2 = row2==maxRow?maxRow:row2+1;
        }
    }
}