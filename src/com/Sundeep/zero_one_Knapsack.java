package com.Sundeep;

import java.util.Arrays;

public class zero_one_Knapsack {
    public static void main(String[] args) {
        int[] w = {2,3,5};
        int[] v = {30,40,60};
        int W = 6;
        System.out.println(getMaxprofit(w.length-1,6,v,w));
        int[][] dp = new int[w.length][W+1];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        System.out.println(getMaxProfitMM(w.length - 1,W,v,w,dp));
        System.out.println(getMaxProfitTb(w,v,W));
        System.out.println(getMaxProfitOP1(w,v,W));
        System.out.println(getMaxProfitOP2(w,v,W));
    }

    public static int getMaxprofit(int ind, int W,int[] value, int[] weight){
        if(ind == 0){
            if(weight[0] <= W)
                return value[0];
            else return 0;
        }

        int notTake = 0 + getMaxprofit(ind - 1,W,value,weight);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= W)
            take = value[ind] + getMaxprofit(ind - 1,W - weight[ind],value,weight);

        return Math.max(take,notTake);
    }

    //Usingg Memoization
    public static int getMaxProfitMM(int ind, int W, int[] value, int[] weight,int[][] dp){
        if(ind == 0){
            if(weight[0] <= W)
                return value[0];
            else return 0;
        }
        if(dp[ind][W] != -1)
            return dp[ind][W];

        int notTake = 0 + getMaxprofit(ind - 1,W,value,weight);
        int take = Integer.MIN_VALUE;
        if(weight[ind] <= W)
            take = value[ind] + getMaxprofit(ind - 1,W - weight[ind],value,weight);

        return dp[ind][W] = Math.max(take,notTake);
    }

    //Using Tabulation
    public static int getMaxProfitTb(int[] weight, int[] value,int W){
        int n = weight.length;
        int[][] dp = new int[n][W+1];
        for(int i=weight[0]; i<=W;i++)
            dp[0][i] = value[0];

        for(int ind = 1;ind < n;ind++){
            for(int w = 0;w<= W;w++){
                int notTake = 0 + dp[ind - 1][w];
                int take = Integer.MIN_VALUE;
                if(weight[ind] <= w)
                    take = value[ind] + dp[ind - 1][w - weight[ind]];

                dp[ind][w] = Math.max(take,notTake);
            }
        }
        return dp[n-1][W];
    }

    //SPace optimization : Using 2 arrays
    public static int getMaxProfitOP1(int[] wt, int[] val, int maxW){
        int n = wt.length;
        int[] prev = new int[maxW+1];
        int[] cur = new int[maxW+1];
        for(int i=wt[0]; i<=maxW;i++)
            prev[i] = val[0];

        for(int ind = 1;ind < n;ind++){
            for(int w = 0;w<= maxW;w++){
                int notTake = 0 + prev[w];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= w)
                    take = val[ind] + prev[w - wt[ind]];

                cur[w] = Math.max(take,notTake);
            }
            prev = cur;
        }
        return prev[maxW];
    }
    //Most Optimal: Using 1 array only , by just filling from right to left as w - wt[w] means that only left part of array
    //is needed to fill the current index so bby just filling the array from right will help us to fill the whole array
    //and make changes in same array without needing any cur[] array. Just changing the above function little bit:
    public static int getMaxProfitOP2(int[] wt, int[] val, int maxW){
        int n = wt.length;
        int[] prev = new int[maxW+1];
        for(int i=wt[0]; i<=maxW;i++)
            prev[i] = val[0];

        for(int ind = 1;ind < n;ind++){
            for(int w = maxW;w>= 0;w--) {
                int notTake = 0 + prev[w];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= w)
                    take = val[ind] + prev[w - wt[ind]];

                prev[w] = Math.max(take, notTake);
            }
        }
        return prev[maxW];
    }
}
