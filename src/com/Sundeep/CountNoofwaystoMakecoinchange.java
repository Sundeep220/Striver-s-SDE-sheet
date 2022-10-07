package com.Sundeep;

import java.util.Arrays;

public class CountNoofwaystoMakecoinchange {
    public static void main(String[] args) {
        int n =1000;
        int[] a = {7,5,1};
        System.out.println(getCount(a.length-1,n,a));
        int[][] dp = new int[a.length][n+1];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        System.out.println(getCount(a.length-1,n,a,dp));
        System.out.println(getCount(a,n));
        System.out.println(getCountOP(a,n));
    }

    //Using Recursion
    public static int getCount(int ind, int target,int[] a){
        if(ind == 0){
            if(target % a[0] == 0)
                return 1;
            else return 0;
        }

        int notTake = 0 + getCount(ind - 1,target,a);
        int take = 0;
        if(a[ind] <= target)
            take = getCount(ind,target-a[ind],a);

        return take + notTake;
    }

    //Using memoization
    public static int getCount(int ind,int target, int[] a, int[][] dp){
        if(ind == 0){
            if(target % a[0] == 0)
                return 1;
            else return 0;
        }
        if(dp[ind][target] != - 1)
            return dp[ind][target];

        int notTake = 0 + getCount(ind - 1,target,a);
        int take = 0;
        if(a[ind] <= target)
            take = getCount(ind,target-a[ind],a);

        return dp[ind][target] = take + notTake;
    }

    //Tabulation
    public static int getCount(int[] a, int sum){
        int n = a.length;
        int[][] dp = new int[n][sum+1];

        for(int i=0;i<=sum;i++){
            if(i % a[0] == 0)
                dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target <= sum;target++){
                int notTake = 0 + dp[ind - 1][target];
                int take = 0;
                if(a[ind] <= target)
                    take = dp[ind][target-a[ind]];
                dp[ind][target] = take + notTake;
            }
        }
        return dp[n-1][sum];
    }
    //Space otptimization
    public static int getCountOP(int[] a, int sum){
        int n = a.length;
        int[] prev = new int[sum+1];
        int[] cur = new int[sum+1];
        for(int i=0;i<=sum;i++){
            if(i % a[0] == 0)
                prev[i] = 1;
            else prev[i] = 0;
        }

        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target <= sum;target++){
                int notTake = 0 + prev[target];
                int take = 0;
                if(a[ind] <= target)
                    take = cur[target-a[ind]];
                cur[target] = take + notTake;
            }
            prev = cur;
        }
        return prev[sum];
    }
}
