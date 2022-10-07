package com.Sundeep;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumPathFallingsum {
    public static void main(String[] args) {
        int[][] cost = {
                {1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1}
        };
        int m = 4,n= 4;
        int[][] dp = new int[n][m];
        for(int[] r : dp)
            Arrays.fill(r,-1);

        int maxi = Integer.MIN_VALUE;
        for(int j=0; j<m;j++){
            int ans = getMaxUtil(n-1,j,m,cost,dp);
            maxi = Math.max(maxi,ans);
        }
        System.out.println(maxi);
        System.out.println(MaximumFallSumUtil(cost));
        System.out.println(getMaxPathSum(cost));
        System.out.println(getMaxSumOP(cost));
    }

    //In this the starting and ending points both are varing
    //Recursion
    public static int MaximumFallSumUtil(int[][] cost){
        int n = cost.length;
        int m = cost[0].length;
        int max = (int) -1e9;
        for(int i= 0;i<m;i++){
            max = Math.max(max,MaximumFallSum(n-1,i,m,cost));
        }
        return max;
    }
    public static int MaximumFallSum(int i,int j,int m,int[][] cost){
        if(j >= m || j < 0)
            return (int)-1e9;
        if(i == 0)
            return cost[0][j];
        int up = cost[i][j] + MaximumFallSum(i-1,j,m,cost);
        int leftDiagonal = cost[i][j] + MaximumFallSum(i-1,j-1,m,cost);
        int rightDiagonal = cost[i][j] + MaximumFallSum(i-1,j+1,m,cost);
        return Math.max(up,Math.max(leftDiagonal,rightDiagonal));
    }

    //Using memoization
    static int getMaxUtil(int i, int j, int m, int[][] matrix,int[][] dp){

        // Base Conditions
        if(j<0 || j>=m)
            return (int)Math.pow(-10,9);
        if(i==0)
            return matrix[0][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up = matrix[i][j] + getMaxUtil(i-1,j,m,matrix,dp);
        int leftDiagonal = matrix[i][j] + getMaxUtil(i-1,j-1,m,matrix,dp);
        int rightDiagonal = matrix[i][j] + getMaxUtil(i-1,j+1,m,matrix,dp);

        return dp[i][j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));

    }
    //Using Tabulation
    static int getMaxPathSum(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(-10,9);

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(-10,9);

                dp[i][j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));

            }
        }

        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }

        return maxi;
    }

    //Optimized : Space optimized
    public static int getMaxSumOP(int[][] c){
        int n = c.length;
        int m = c[0].length;
        int[] prev = new int[n];
        int[] cur = new int[n];

        for(int j=0;j<m;j++)
            prev[j] = c[n-1][j];
        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = c[i][j] + prev[j];

                int leftDiagonal= c[i][j];
                if(j-1>=0) leftDiagonal += prev[j-1];
                else leftDiagonal += (int)Math.pow(-10,9);

                int rightDiagonal = c[i][j];
                if(j+1<m) rightDiagonal += prev[j+1];
                else rightDiagonal += (int)Math.pow(-10,9);

                cur[j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));

            }
            prev = cur.clone();
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            maxi = Math.max(maxi,prev[i]);

        return maxi;
    }
}
