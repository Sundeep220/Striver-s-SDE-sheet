package com.Sundeep;

public class minimumSubsetPartition {
    public static void main(String[] args) {
    int[] a = {5,3,7};
        System.out.println(minSubsetpart(a,3));
    }

    public static int minSubsetpart(int[] a, int n){
        int totSum =0;
        for(int i=0;i<n;i++)
            totSum += a[i];
        int k = totSum;
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(a[0]<=k)
            dp[0][a[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(a[ind]<=target)
                    taken = dp[ind-1][target-a[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }
        //Now after filling this table from the last row take minimum of all possible sums and return it as answer
        //i.e, dp[n-1][col:0.......totSum] will give all possible sums for given subsets
        int mini = (int)1e9;
        for(int s1 = 0; s1 <= totSum/2;s1++){
            //taking totSum / 2 as after 1st half, values will just get repeated for s2
            if(dp[n-1][s1]) {
                int s2 = totSum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        return mini;

    }
}
