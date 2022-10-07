package com.Sundeep;

import java.util.Arrays;

public class PartitioningInto2Subsets {
    public static void main(String[] args) {
        int[] a = {2,3,3,3,4,5};
        System.out.println(canPartition(a,6));
        System.out.println(canPartitionMM(a,6));
    }

    public static boolean canPartition(int[] a,int n){
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += a[i];
        if((sum&1) == 1)
            return false;
        return SubsetSumEqtoSby2(n-1,a,sum/2);
    }

    public static boolean SubsetSumEqtoSby2(int ind,int[] a, int K){
        if(K == 0)
            return true;
        if(ind == 0)
            return a[0] == K;

        boolean notTake = SubsetSumEqtoSby2(ind-1,a,K);
        boolean Take = false;
        if(a[ind] <= K)
        Take = SubsetSumEqtoSby2(ind-1,a,K-a[ind]);

        return notTake || Take;
    }

    //Using memoization
    public static boolean canPartitionMM(int[] a, int n){
        int sum = 0;
        for(int i : a)
            sum += i;
        if((sum&1) == 1)
            return false;
        int[][] dp = new int[n][sum/2 + 1];
        for(int[] row : dp)
        Arrays.fill(row,-1);
        return SubSetSumMM(n-1,a,sum/2,dp);
    }
    public static boolean SubSetSumMM(int ind, int[] a, int K, int[][] dp){
        if(K == 0)
            return true;
        if(ind == 0)
            return a[0] == K;

        if(dp[ind][K] != -1)
            return dp[ind][K] == 0 ? false:true;

        boolean notTake = SubSetSumMM(ind-1,a,K,dp);
        boolean Take = false;
        if(a[ind] <= K)
            Take = SubSetSumMM(ind-1,a,K-a[ind],dp);

        dp[ind][K] = notTake||Take ? 1:0;

        return notTake || Take;
    }
}
