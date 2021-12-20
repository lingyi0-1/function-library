package kuan.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵计算
 * Created by zgk on 2021/12/17.
 */
public class MatrixCalculation {
    public static void main(String[] args) {

        MatrixCalculation A = new MatrixCalculation();

        System.out.println("请输入第一个矩阵信息：");
        int[][] matrix1 = A.enterMatrix();
        System.out.println("请输入第二个矩阵信息：");
        int[][] matrix2 = A.enterMatrix();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要进行的运算(加法输入‘+’，乘法输入‘*’)：");
        char calculation = scanner.next().charAt(0);
        if(calculation == '+'){
            int[][] a = A.matrixAddition(matrix1, matrix2);
            for(int i=0;i<a.length;i++){
                System.out.println(Arrays.toString(a[i]));
            }
        }else if(calculation == ('*')){
            int[][] a = A.matrixMultiplication(matrix1, matrix2);
            for(int i=0;i<a.length;i++){
                System.out.println(Arrays.toString(a[i]));
            }
        }
    }

    int[][] enterMatrix(){
        Scanner scanner = new Scanner(System.in); //创建Scanner对象
        System.out.println("请输入矩阵行数：");
        int row = scanner.nextInt();
        System.out.println("请输入矩阵列数：");
        int col = scanner.nextInt();
        System.out.println("请输入矩阵，最后以回车结束：");
        while(scanner.hasNext()){
            int[][] matrix = new int[row][col];
            for(int i = 0; i < row*col;i++){
                matrix[i/col][i%col] = scanner.nextInt();
            }
            return matrix;
        }
        return null;
    }

    int[][] matrixAddition(int[][] matrix1,int[][] matrix2){
        int matrix1row = matrix1.length;
        int matrix1col = matrix1[0].length;
        int matrix2row = matrix2.length;
        int matrix2col = matrix2[0].length;
        if(matrix1row == matrix2row && matrix1col == matrix2col){
            int[][] result = new int[matrix1row][matrix1col];
            for(int i = 0; i < matrix1row*matrix1col;i++){
                result[i/matrix1col][i%matrix1col] = matrix1[i/matrix1col][i%matrix1col] + matrix2[i/matrix1col][i%matrix1col];
            }
            return result;
        }
        return null;
    }

    int[][] matrixMultiplication(int[][] matrix1,int[][] matrix2){
        int matrix1row = matrix1.length;
        int matrix1col = matrix1[0].length;
        int matrix2row = matrix2.length;
        int matrix2col = matrix2[0].length;
        if(matrix1col == matrix2row){
            int[][] result = new int[matrix1row][matrix2col];
            for(int i = 0; i < matrix1row*matrix2col;i++){
                result[i/matrix2col][i%matrix2col] = 0;
                for(int j = 0; j < matrix1col; j++){
                    result[i/matrix2col][i%matrix2col] = result[i/matrix2col][i%matrix2col]+ matrix1[i/matrix2col][j] * matrix2[j][i%matrix2col];
                }
            }
            return result;
        }
        return null;
    }
}
