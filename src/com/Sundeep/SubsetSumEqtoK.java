package com.Sundeep;

import java.util.Arrays;

public class SubsetSumEqtoK {
    //Using memoization
    static boolean subsetSumUtil(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    static boolean subsetSumToK(int n, int k,int[] arr){

        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return subsetSumUtil(n-1,k,arr,dp);
    }
//-----------------------------------------------------
    //Using Tabulation
static boolean subsetSumToKTB(int n, int k,int[] arr){


    boolean dp[][]= new boolean[n][k+1];
    //Base case
    for(int i=0; i<n; i++){
        dp[i][0] = true;
    }
    //second base case
    if(arr[0]<=k)
        dp[0][arr[0]] = true;

    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=k; target++){

            boolean notTaken = dp[ind-1][target];

            boolean taken = false;
            if(arr[ind]<=target)
                taken = dp[ind-1][target-arr[ind]];

            dp[ind][target]= notTaken||taken;
        }
    }

    return dp[n-1][k];
}
//------------------------
    //Space Optimized
static boolean subsetSumToKTBOP(int n, int k,int[] arr){


    boolean prev[]= new boolean[k+1];
    boolean cur[] = new boolean[k+1];
    prev[0] = cur[0] = true;
    prev[arr[0]] = true;
    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=k; target++){
            boolean notTaken = prev[target];
            boolean taken = false;
            if(arr[ind]<=target)
                taken = prev[target-arr[ind]];

            cur[target]= notTaken||taken;
        }
        prev = cur;
    }

    return prev[k];
}
    public static void main(String args[]) {

        int arr[] = {1,2,3,4};
        int k=4;
        int n = arr.length;

//        if(subsetSumToK(n,k,arr))
//            System.out.println("Subset with given target found");
//        else
//            System.out.println("Subset with given target not found");
        System.out.println(subsetSumToKTBOP(n,k,arr));
    }
}
