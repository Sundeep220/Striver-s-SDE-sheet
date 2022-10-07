package com.Sundeep;

import java.util.Arrays;

public class gridUniquePaths {
    public static void main(String[] args) {
        int m = 3,n = 3;
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        System.out.println(uniquePaths(m-1,n-1,dp));
        System.out.println(gridPaths(m,n));
        System.out.println(uniquePaths(m,n));
    }

    //Using memoization
    public static int uniquePaths(int m, int n, int[][] dp){
        if(m == 0 && n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;

        if(dp[m][n] != -1)
            return dp[m][n];

        return dp[m][n] = uniquePaths(m-1,n,dp) + uniquePaths(m,n-1,dp);
    }


    //USing Tabulation
    public static int gridPaths(int m , int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int up,left;
                    up = (i > 0) ? dp[i-1][j] : 0 ;
                    left = (j > 0) ? dp[i][j-1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    //Optimal Solution: 1
    public static int uniquePaths(int m , int n){
        int[] prev = new int[n];
        for(int i = 0;i < m ;i ++){
            int[] cur = new int[n];
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0)
                    cur[j] = 1;
                else {
                    int up,left;
                    up = (i > 0) ? prev[j] : 0 ;
                    left = (j > 0) ? cur[j-1] : 0;
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }

    //Most Optimal Solution :
    public int uniquePathsCombinatrics(int m, int n) {
        //Using Combinatric i.e permutations annd combinations
        // as for mxn matrix total number of paths from start to end are m-1 + n-1 = m+n-2
        // for unique paths it is equal= m+n-2Cm-1 or m+n-2Cn-1 as nCr = nCn-r
        int totalpaths = m + n - 2;
        int r = m-1;
        double res = 1;
        for(int i=1;i<=r;i++){
            res = res * (totalpaths - r +i)/i;
        }
        return (int)res;
    }
}
