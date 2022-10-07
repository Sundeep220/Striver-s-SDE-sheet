package com.Sundeep;

import java.util.Arrays;

public class MinimumPathSumonGrid {
    public static void main(String[] args) {
        int m = 3, n =3;
        int[][] cost = {
                {10,5,2},
                {1,6, 15},
                {1,1,2}
        };
        System.out.println(minPathSum(cost,m-1 ,n-1));
        System.out.println(minPathSumUtil(cost,m,n));
        System.out.println(minPathSumTb(cost,m,n));
        System.out.println(minPathSumOp(cost,m,n));
    }

    //Using Recursion
    public static int minPathSum(int[][] cost,int m, int n){
        if(m == 0 && n == 0)
            return cost[0][0];
        if(m < 0 || n < 0 ) return (int)1e9;
        int up = cost[m][n] + minPathSum(cost,m-1,n);
        int left = cost[m][n] + minPathSum(cost,m ,n-1);
        return Math.min(up,left);
    }

    //Using memoization
    public static int minPathSumUtil(int[][] cost, int m, int n){
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return minPathSumMM(cost,m-1,n-1,dp);
    }
    public static int minPathSumMM(int[][] cost,int m ,int n , int[][] dp){
        if(m == 0 && n == 0)
            return cost[0][0];
        if(m < 0 || n < 0 ) return (int)1e9;
        if(dp[m][n] != -1)
            return dp[m][n];
        int up = cost[m][n] + minPathSum(cost,m-1,n);
        int left = cost[m][n] + minPathSum(cost,m ,n-1);
        return dp[m][n] = Math.min(up,left);
    }

    //Using Tabulation

    public static int minPathSumTb(int[][] cost, int m,int n){
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0)
                    dp[0][0] = cost[0][0];
                else{
                    int max = (int)1e9;
                    int up = (i>0)? cost[i][j] + dp[i-1][j]: max ;
                    int left = (j>0)? cost[i][j] + dp[i][j-1] : max;
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    //Optimized
    public static int minPathSumOp(int[][] cost, int m ,int n){
        int[] prev = new int[n];
        for(int i = 0;i<m;i++){
            int[] cur = new int[n];
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0)
                    cur[j] = cost[i][j];
                else{
                    int max = (int)1e9;
                    int up = (i>0)? cost[i][j] + prev[j]: max ;
                    int left = (j>0)? cost[i][j] + cur[j-1] : max;
                    cur[j] = Math.min(up,left);
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}
