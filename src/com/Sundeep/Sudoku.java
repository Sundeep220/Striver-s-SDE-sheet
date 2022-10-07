package com.Sundeep;

public class Sudoku {
    public static void main(String args[])
    {

        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };


        if (solveSudoku(board))
        {
            // print solution
            print(board);
        }
        else {
            System.out.println("No solution");
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        //Check for this whole row
        for(int i=0;i<board.length;i++){
            //Check if the number is in row
                if(board[row][i] == num){
                    return false;
                }
            }

        //Check the col
        for(int[] nums : board){
            if(nums[col] == num)
                return false;
        }

        //Check for the small box as well
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for(int r = rowStart;r < rowStart+sqrt;r++){
            for(int c = colStart;c < colStart+sqrt; c++){
                if(board[r][c] == num)
                    return false;
            }
        }
        return true;

    }

    //Function to solve Sudoku
    static boolean solveSudoku(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        //this is how we are checking for empty values and soving the sudoku
        boolean emptySpacesLeft = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptySpacesLeft = false;
                    break;
                }
            }
            //if we found an empty element in row then break
            if(!emptySpacesLeft)
                break;
        }

        //After this loop if we didn't find any empty places that means sudoku is solved
        if(emptySpacesLeft)
            return true;

        //backtracking
        for(int number = 1; number <= 9; number++){
            if(isSafe(board,row,col,number)){
                board[row][col] = number;
                //After considering this answer again check if this gives correct answer or not
                if(solveSudoku(board)){
                    return true;
                }else board[row][col] = 0; //Otherwise replace those changes ,i.e., backtrack
            }
        }
        return false;
    }

    static void print(int[][] board){
        for(int[] row : board){
            for(int num : row){
                System.out.print(num+ " ");
            }
            System.out.println();
        }
    }
}


