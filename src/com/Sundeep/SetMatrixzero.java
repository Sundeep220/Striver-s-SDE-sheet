package com.Sundeep;

import java.util.Arrays;

public class SetMatrixzero {
    //Using Brute Force
    static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {

                    int ind = i - 1;
                    while (ind >= 0) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }
                    ind = i + 1;
                    while (ind < rows) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }
                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind--;
                    }
                    ind = j + 1;
                    while (ind < cols) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //Using two dummy arrays
    static void setmatrixzeroesusingdummy(int[][] matrix){
        int row[] = new int[matrix.length];
        int col[] =  new int[matrix[0].length];
        Arrays.fill(row,-1);
        Arrays.fill(col,-1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row[i] = 0;   //set the ith element in riw array to 0
                    col[j] = 0;   // set the jth element in col to 0
                }
            }

        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i] == 0 || col[j] == 0 )
                    matrix[i][j] = 0;
            }
        }
    }
   //Optimized approach using dummy arrays inside the matrix only
    //Instead of taking two separate dummy array,take first row and column of the matrix as
   // the array for checking whether the particular column or row has the value 0 or not.
   // Since matrix[0][0] are overlapping.Therefore take separate variable col0(say) to check if the
   // 0th column has 0 or not and use matrix[0][0] to check if the 0th row has 0 or not.Now traverse
   // from last element to the first element and check if matrix[i][0]==0 || matrix[0][j]==0
   // and if true set matrix[i][j]=0,else continue.
   static void setZeroesoptimized(int[][] matrix) {
       int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        //using col0 as a flag for matrix[0][0] as it is responsible for 1st col elements
       for (int i = 0; i < rows; i++) {
           if (matrix[i][0] == 0) col0 = 0;
           for (int j = 1; j < cols; j++)
               if (matrix[i][j] == 0)
                   matrix[i][0] = matrix[0][j] = 0;
       }
        //traversing the array from end to avoid matrix[0][0] to get changed at first.
       for (int i = rows - 1; i >= 0; i--) {
           for (int j = cols - 1; j >= 1; j--)
               if (matrix[i][0] == 0 || matrix[0][j] == 0)
                   matrix[i][j] = 0;
           if (col0 == 0) matrix[i][0] = 0;
       }
   }

    public static void main(String[] args) {
	// write your code here
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        //setZeroes(arr);
        //setmatrixzeroesusingdummy(arr);
        setZeroesoptimized(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
