package kuan.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵计算
 * Created by zgk on 2021/12/17.
 */
public class Matrix {


    public static void main(String[] args) {


        System.out.println("请输入第一个矩阵信息：");
        Matrix matrix1 = new Matrix();
        System.out.println("请输入第二个矩阵信息：");
        Matrix matrix2 = new Matrix();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要进行的运算(加法输入‘+’，乘法输入‘*’)：");
        char calculation = scanner.next().charAt(0);
        if(calculation == '+'){
            matrix1.exportMatrix(matrix1.matrixAddition(matrix2));
        }else if(calculation == ('*')){
            matrix1.exportMatrix(matrix1.matrixMultiplication(matrix2));
        }
    }

    int row;
    int col;
    int[][] matrix;

    public Matrix(){
        Scanner scanner = new Scanner(System.in); //创建Scanner对象
        System.out.println("请输入矩阵行数：");
        this.row = scanner.nextInt();
        System.out.println("请输入矩阵列数：");
        this.col = scanner.nextInt();
        System.out.println("请输入矩阵：");
        this.matrix = new int[this.row][this.col];
        for(int i = 0; i < this.row * this.col;i++){
            this.matrix[i/this.col][i%this.col] = scanner.nextInt();
        }
    }

    int[][] matrixAddition(Matrix anotherMatrix){
        if(this.row == anotherMatrix.row && this.col == anotherMatrix.col){
            int[][] result = new int[this.row][this.col];
            for(int i = 0; i < this.row * this.col;i++){
                result[i/this.col][i%this.col] = this.matrix[i/this.col][i%this.col] + anotherMatrix.matrix[i/this.col][i%this.col];
            }
            return result;
        }else{
            System.out.println("这两个矩阵无法进行加运算");
        }
        return null;
    }

    int[][] matrixMultiplication(Matrix anotherMatrix){
        if(this.col == anotherMatrix.row){
            int[][] result = new int[this.row][anotherMatrix.col];
            for(int i = 0; i < this.row * anotherMatrix.col;i++){
                result[i/anotherMatrix.col][i%anotherMatrix.col] = 0;
                for(int j = 0; j < this.col; j++){
                    result[i/anotherMatrix.col][i%anotherMatrix.col] = result[i/anotherMatrix.col][i%anotherMatrix.col]+ this.matrix[i/anotherMatrix.col][j] * anotherMatrix.matrix[j][i%anotherMatrix.col];
                }
            }
            return result;
        }else{
            System.out.println("这两个矩阵无法进行乘运算");
        }
        return null;
    }

    void exportMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
