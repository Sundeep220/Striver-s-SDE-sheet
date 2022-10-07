package com.Sundeep;

import java.rmi.MarshalException;
import java.util.Arrays;

public class CherryPicupii {
    public static void main(String[] args) {
        int[][] a = {
                {2,3,1,2},
                {3,4,2,2},
                {5,6,3,5},
        };
        int[][] b= {
                {1, 1},
                {1, 2}
        };
        int n = 3,m = 4;
        System.out.println(MaxCherryPick(a,n,m));
        System.out.println(MaxCherryPick(b,2,2));
        System.out.println(MaxCherryPickDP(a,n,m));
    }

    //Using Recursion
    public static int MaxCherryPick(int[][] cherry,int n,int m){
        return getMaxCherryPick(0,0,m-1,cherry,n,m);
    }

    public static int getMaxCherryPick(int i, int j1, int j2, int[][] c,int n,int m){
        //Base case
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e8;
        if(i == n-1){
            if(j1 == j2)
                return c[i][j1];
            else return c[i][j1] + c[i][j2];
        }
        //Generalization of Recurrance
        int maxi = Integer.MIN_VALUE;
        int subAns = 0;
        for(int dj1 = -1; dj1 <= 1;dj1++){
            for(int dj2 = -1;dj2 <= 1;dj2++){
                if(j1 == j2){
                    subAns = c[i][j1] + getMaxCherryPick(i+1,j1 + dj1, j2 + dj2,c,n,m);
                    maxi = Math.max(maxi,subAns);
                }
                else {
                    subAns = c[i][j1] + c[i][j2] + getMaxCherryPick(i + 1, j1 + dj1, j2 + dj2, c, n, m);
                    maxi = Math.max(maxi, subAns);
                }
            }
        }
        return maxi;
    }

    //Using memoization
    //Since 3 parameters use 3D Array dp
    public static int MaxCherryPickDP(int[][] c,int n,int m){
        int[][][] dp = new int[n][m][m];
        for(int[][] ma : dp)
            for(int[] r: ma)
                Arrays.fill(r,-1);
        return getMaxCherryPickDp(0,0,m-1,c,n,m,dp);
    }

    public static int getMaxCherryPickDp(int i, int j1,int j2,int[][] c,int n,int m, int[][][] dp){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) -1e8;

        if(i == n-1){
            if(j1 == j2)
                return c[i][j1];
            else return c[i][j1] + c[i][j2];
        }
        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        int subAns = 0;
        for(int dj1 = -1; dj1 <= 1;dj1++){
            for(int dj2 = -1;dj2 <= 1;dj2++){
                if(j1 == j2){
                    subAns = c[i][j1] + getMaxCherryPick(i+1,j1 + dj1, j2 + dj2,c,n,m);
                    maxi = Math.max(maxi,subAns);
                }
                else {
                    subAns = c[i][j1] + c[i][j2] + getMaxCherryPick(i + 1, j1 + dj1, j2 + dj2, c, n, m);
                    maxi = Math.max(maxi, subAns);
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}
