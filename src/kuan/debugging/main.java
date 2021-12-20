package kuan.debugging;

import java.util.Scanner;

/**
 * Created by zgk on 2021/12/17.
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //创建Scanner对象
        System.out.println("请输入矩阵行数：");
        int row = scanner.nextInt();
        System.out.println("请输入矩阵列数：");
        int col = scanner.nextInt();
        System.out.println("请输入矩阵，最后以回车结束：");
        int[][] matrix = new int[row][col];
        while(scanner.hasNext()){
            for(int i = 0; i < row*col;i++){
                matrix[i/col][i%col] = scanner.nextInt();
            }
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            scanner.close();
        }
    }
}
