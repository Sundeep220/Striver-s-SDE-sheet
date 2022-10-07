package com.Sundeep;

import java.util.Arrays;

public class MinimumPathTriangle {
    public static void main(String[] args) {
        int[][] triangle = {
                {1},
                {2,3},
                {4,5,6},
                {7,8,9,10}
        };
        int n =4;
        int[][] dp = new int[n][n];
        for(int[] r :dp)
            Arrays.fill(r,-1);
        System.out.println(minSumTri(triangle,4,0,0));
        System.out.println(minSumTriMM(triangle,n,0,0,dp));
        System.out.println(minSumTriTB(triangle,n));
        System.out.println(minSumTriOp(triangle,n));
    }

    //In this the starting point is fixed but ending point is variable and we are given a triangular matrix
    //Using recursion
    public static int minSumTri(int[][] triangle,int n,int i,int j){
        //If you reach the end of row
        if(i == n-1)
            return triangle[n-1][j];

        return Math.min(triangle[i][j] + minSumTri(triangle,n,i+1,j),triangle[i][j] + minSumTri(triangle,n,i+1,j+1));
    }

    //Using memoization
    public static int minSumTriMM(int[][] triangle,int n, int i, int j ,int[][] dp){
        if(i == n-1)
            return triangle[n-1][j];
        if(dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = Math.min(triangle[i][j] + minSumTri(triangle,n,i+1,j),triangle[i][j] + minSumTri(triangle,n,i+1,j+1));
    }

    //Using tabulatioon
    public static int minSumTriTB(int[][] t, int n){
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[n-1][i] = t[n-1][i];

        for(int i = n-2;i>=0;i--){
            for(int j = i; j >=0 ;j--){
                dp[i][j] = Math.min(t[i][j] + dp[i+1][j],t[i][j] + dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    //Space Optimization
    public static int minSumTriOp(int[][] t, int n){
        int[] front = new int[n];
        for(int i=0;i<n;i++)
            front[i] = t[n-1][i];

        for(int i=n-2;i>=0;i--){
            int[] cur = new int[n];
            for(int j = i;j>=0;j--){
                cur[j] = Math.min(t[i][j] + front[j],t[i][j] + front[j+1]);
            }
            front = cur.clone();
        }
        return front[0];
    }
}
