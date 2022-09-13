package com.Sundeep;

public class search_in_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0; //taking lowerbound
        int col = matrix[0].length-1; //taking upper bound
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target)
                row++;
            else col--;
        }
        return false;
    }
}
