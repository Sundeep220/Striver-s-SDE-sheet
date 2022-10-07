package com.Sundeep;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board= new boolean[n][n];
        //Nknights(board,0,0,4);
        System.out.println(countKnights(board,0));
    }

    static void Nknights(boolean[][] board,int row,int col, int knights){
        if(knights==0){
            display(board);
            System.out.println();
            return;
        }
        //for edge case when col goes out of bounds
        if(row == board.length-1 && col == board.length)
            return;

        //if we reached the end of row go to next line
        if(col == board.length) {
            Nknights(board, row + 1, 0, knights);
            return;
        }
        //Check if it safe to put knight in tha postion, if yes then put it and call for next col
        if(isSafe(board,row,col)){
            board[row][col] = true;
            Nknights(board,row,col+1,knights-1);
            board[row][col] = false;
        }

        //Else if you cant find the position in that col then simply go for next col but dont decrement knights
        Nknights(board,row,col+1,knights);

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //4 Conditions to check for previous possible positions of knights
        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1])
                return false;
        }
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1])
                return false;
        }
        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2])
                return false;
        }
        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2])
                return false;
        }
        return true;
    }

    static boolean isValid(boolean[][] board,int row,int col){
        if(row >=0 && row < board.length && col >=0 && col < board.length){
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){
                    System.out.print("K ");
                }
                else System.out.print("O ");
            }
            System.out.println();
        }
    }

    //To return count also
    static int countKnights(boolean[][] board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing Knight in every column of row to check for possibilities
        for(int col=0;col<board.length;col++){
            //If it is safe to put Knight then put it in board and call for below matrix recursion
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += countKnights(board,row+1);
                board[row][col] = false;  //Removing the changes made by this call
            }

        }

        return count;
    }
}
