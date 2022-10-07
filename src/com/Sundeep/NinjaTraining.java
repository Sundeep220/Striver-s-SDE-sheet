package com.Sundeep;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] a = {
                {10,40,70},
                {20,50,80},
                {30,60,90}
        };
        System.out.println(maxMerit(a,3));
        System.out.println(maxMeritDP(a,3));
        System.out.println(maxMeriitTabular(a,3));
        System.out.println(maxMeritOptimized(a,3));
    }
    //Using Recursion
    public static int maxMerit(int[][] tasks,int n){
        return getMaxMerit(n-1,3,tasks);
    }

    public static int getMaxMerit(int day, int last, int[][] tasks){
        if(day == 0){
            int maxi = 0;
            for(int i=0;i<3;i++){
                if(i != last)
                    maxi = Math.max(maxi,tasks[0][i]);
            }
            return maxi;
        }

        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i != last){
                int points = tasks[day][i] + getMaxMerit(day - 1,i,tasks);
                maxi = Math.max(maxi,points);
            }
        }
        return maxi;
    }

    //Using memoization
    public static int maxMeritDP(int[][] tasks,int n){
        int[][] dp = new int[n][4];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return getMaxMeritDp(n-1,3,tasks,dp);
    }

    public static int getMaxMeritDp(int day, int last, int[][] tasks, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int i=0;i<3;i++){
                if(i != last)
                    maxi = Math.max(maxi,tasks[0][i]);
            }
            return maxi;
        }
        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i != last){
                int points = tasks[day][i] + getMaxMeritDp(day - 1,i,tasks,dp);
                maxi = Math.max(maxi,points);
            }
        }
        return dp[day][last] = maxi;
    }

    //Using Tabulation T-(Nx4x3) S - (O)Nx4
    public static int maxMeriitTabular(int[][] tasks, int n){
        int[][] dp = new int[n][4];
        //base case
        dp[0][0] = Math.max(tasks[0][1],tasks[0][2]);
        dp[0][1] = Math.max(tasks[0][0],tasks[0][2]);
        dp[0][2] = Math.max(tasks[0][0],tasks[0][1]);
        dp[0][3] = Math.max(tasks[0][0],Math.max(tasks[0][1],tasks[0][2]));



        for(int day=1;day<n;day++){
            for(int last = 0;last<4;last++){
                dp[day][last] = 0;
                for(int i=0;i<3;i++){
                    if(i != last){
                        dp[day][last] = Math.max(dp[day][last], tasks[day][i] + dp[day - 1][i]);
                    }
                }
            }
        }
        return dp[n-1][3];

    }
    //Optimized solution with reducing nx4 space to O(4)
    public static int maxMeritOptimized(int[][] tasks,int n){
        int[] prev = new int[4];
        prev[0] = Math.max(tasks[0][1],tasks[0][2]);
        prev[1] = Math.max(tasks[0][0],tasks[0][2]);
        prev[2] = Math.max(tasks[0][0],tasks[0][1]);
        prev[3] = Math.max(tasks[0][0],Math.max(tasks[0][1],tasks[0][2]));

        for(int day = 1;day < n;day++){
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;
                for(int i = 0;i<3;i++){
                    if(i != last){
                        temp[last] = Math.max(temp[last],tasks[day][i] + prev[i]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }
}
