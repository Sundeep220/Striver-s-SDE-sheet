package com.Sundeep;

import java.util.Arrays;

public class CoinChangeproblem {

    public static void main(String[] args) {
       int n = 18;    // here n denotes total amount of money to sum up to(Kitne rupay bnane h sikko se)
       int a[] = {7,5,1};  // denotes the denomination we currently have to make up n(kitno ke sikke h humare  pass)
        int[][] dp = new int[a.length][n+1];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        System.out.println(minCoins(a.length-1,n,a));
        System.out.println(minCoins(a.length-1,n,a,dp));
        System.out.println(minCoins(a,n));
        System.out.println(minCoinsOP(a,n));
    }
    //Using Recursion
    public static int minCoins(int ind, int target, int[] a){
        if(ind == 0){
            if(target % a[0] == 0)
                return target/a[0];
            else return (int)1e9;
        }

        int notTake = 0 + minCoins(ind-1,target,a);
        int take = Integer.MAX_VALUE;
        if(a[ind] <= target)
            take = 1 + minCoins(ind,target - a[ind],a);

        return Math.min(take,notTake);
    }
    //Using memoization
    public static int minCoins(int ind,int target,int a[],int[][] dp){
        if(ind == 0){
            if(target % a[0] == 0)
                return target/a[0];
            else return (int)1e9;
        }

        if(dp[ind][target] != -1)
            return dp[ind][target];

        int notTake = 0 + minCoins(ind-1,target,a,dp);
        int take = Integer.MAX_VALUE;
        if(a[ind] <= target)
            take = 1 + minCoins(ind,target - a[ind],a,dp);

        return dp[ind][target] = Math.min(take,notTake);
    }

    //Using Tabulation
    public static int minCoins(int[] a, int sum){
        int n = a.length;
        int[][] dp = new int[n][sum+1];

        for(int i = 0;i<=sum;i++){
            if(i % a[0] == 0)
                dp[0][i] = i / a[0];
            else dp[0][i] = (int)1e9;
        }
        for(int ind = 1;ind < n;ind++){
            for(int target = 0; target <= sum; target++){
                int notTake = 0 + dp[ind-1][target];
                int take = Integer.MAX_VALUE;
                if(a[ind] <= target)
                    take = 1 + dp[ind][target - a[ind]];
                dp[ind][target] = Math.min(take,notTake);
            }
        }
        return dp[n-1][sum];
    }

    //Space Optimizing
    public static int minCoinsOP(int[] a, int sum){
        int n = a.length;
        int[] prev = new int[sum+1];
        int[] cur = new int[sum + 1];
        for(int i = 0;i<=sum;i++){
            if(i % a[0] == 0)
                prev[i] = i / a[0];
            else prev[i] = (int)1e9;
        }
        for(int ind = 1;ind < n;ind++){
            for(int target = 0; target <= sum; target++){
                int notTake = 0 + prev[target];
                int take = Integer.MAX_VALUE;
                if(a[ind] <= target)
                    take = 1 + cur[target - a[ind]];
                cur[target] = Math.min(take,notTake);
            }
            prev = cur;
        }
        return prev[sum];
    }


}
