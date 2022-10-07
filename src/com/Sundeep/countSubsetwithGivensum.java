package com.Sundeep;

import java.util.Arrays;

public class countSubsetwithGivensum {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        int[][] dp = new int[a.length][4];
        for(int[] i : dp)
        Arrays.fill(i,-1);
        System.out.println(getCount(a.length -1,3,a));
        System.out.println(getCountMM(a.length-1,3,a,dp));
        System.out.println(getCountTb(a,3,a.length));
    }

    public static int getCount(int i, int sum,int[] a){
        if(i == 0) {
           if(a[i] == 0 && sum == 0)
               return 2;
            if(sum == 0 || sum == a[0])
                return 1;
            return 0;
        }
        int notTaken = getCount(i-1,sum,a);
        int taken = 0;
        if(a[i] <= sum)
            taken = getCount(i-1,sum - a[i],a);

        return notTaken + taken;
    }

    public static int getCountMM(int i,int sum ,int[] a ,int[][] dp){
        if(i == 0) {
            if(a[i] == 0 && sum == 0)
                return 2;
            if(sum == 0 || sum == a[0])
                return 1;
            return 0;
        }
        if(dp[i][sum] != -1)
            return dp[i][sum];
        int notTaken = getCountMM(i-1,sum,a,dp);
        int taken = 0;
        if(a[i] <= sum)
            taken = getCountMM(i-1,sum - a[i],a,dp);

        return dp[i][sum] = notTaken + taken;
    }

    //Using Tabulation
    public static int getCountTb(int[] a, int sum,int n){
        int[][] dp = new int[n][sum + 1];
        //Base case 1
        if(a[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(a[0] <= sum && a[0] !=0) dp[0][a[0]] = 1;
        for(int i = 1; i < n;i++){
            for(int target = 0;target <= sum; target++){
                int nottake = dp[i-1][target];
                int take = 0;
                if(target >= a[i])
                take = dp[i-1][target - a[i]];
                dp[i][target] = take + nottake;
            }
        }
        return dp[n-1][sum];
    }
}
