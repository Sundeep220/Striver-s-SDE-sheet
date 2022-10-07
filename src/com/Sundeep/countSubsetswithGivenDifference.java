package com.Sundeep;

import java.util.Arrays;

public class countSubsetswithGivenDifference {
    public static void main(String[] args) {
        int[] a = {5,2,6,4};
        System.out.println(countPartitionsMM(a,4,3));
        System.out.println(countPartitionsTb(a,4,3));;

    }
    int mod = (int) 1e9 + 7;
    public static int countPartitionsMM(int[] a,int n,int diff){
        int totSum = 0;
        for(int i : a)
            totSum += i;
        if(totSum - diff < 0 || (totSum - diff) % 2 == 1)
            return 0;
        int target = (totSum - diff) / 2;
        int[][] dp = new int[n][target + 1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        return getCountMM(n-1,target,a,dp);
    }
    public static int getCountMM(int i,int sum ,int[] a ,int[][] dp){
        if(i == 0) {
            if(a[0] == 0 && sum == 0)
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
    public static int countPartitionsTb(int[] a,int n,int diff){
        int totSum = 0;
        for(int i : a)
            totSum += i;
        if(totSum - diff < 0 || (totSum - diff) % 2 == 1)
            return 0;
        int target = (totSum - diff) / 2;
        return getCountTb(a,target,n);
    }
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
