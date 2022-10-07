package com.Sundeep;

import java.util.Arrays;

public class MaximumSumofTwoNonAdjacentelements {
    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
       // System.out.println(getMax(n-1,a));

//        System.out.println(getMaxSum(n-1,a,dp));
//        System.out.println(Arrays.toString(dp));
       // System.out.println(getMaxSum(n-1,a,n));
        System.out.println(getMaxSum(n-1,a));
    }
    //Using Recursion
    public static int getMax(int ind, int[] a){
        if(ind == 0)
            return a[ind];
        if(ind < 0)
            return 0;
        int pick = a[ind] + getMax(ind - 2,a);
        int notpick = getMax(ind -1 ,a);

        return Math.max(pick,notpick);
    }

    //Using memoization
    public static int getMaxSum(int ind, int[] a,int[] dp){
        if(ind == 0)
            return dp[ind] = a[ind];
        if(ind < 0)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        int pick = a[ind] + getMaxSum(ind -2, a,dp);
        int notpick = getMaxSum(ind -1,a,dp);

        return dp[ind] = Math.max(pick,notpick);
    }

    //Using tabulation
    public static int getMaxSum(int ind, int[] a,int n){
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(a[0],a[1]);   // or for(int i=1;i<n;i++){
        for(int i = 2;i<n;i++){         //    int pick = a[i];
            int pick = a[i] + dp[i-2];  //    if(i>1) pick += dp[i-2]
            int notpick = 0 + dp[i-1];  //this would work same for left

            dp[i] = Math.max(pick,notpick);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    //Optimized
    public static int getMaxSum(int ind, int[] a){
        int prev = a[0];
        int prev2 = 0;
        int ans;
        for(int i =1;i<a.length;i++){
            int pick = a[i];
            if(i > 1)
                pick += prev2;
            int notpick = prev;

             ans = Math.max(pick,notpick);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }
}
