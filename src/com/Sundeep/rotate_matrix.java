package com.Sundeep;

public class rotate_matrix {
    public void rotate(int[][] matrix) {
        //logic: To first get ranspose of matrix and then reverse the arra
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        //Reversing each row
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }

    }
}
