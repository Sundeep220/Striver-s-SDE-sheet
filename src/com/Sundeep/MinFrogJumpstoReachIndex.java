package com.Sundeep;

import javax.swing.plaf.metal.MetalTheme;
import java.rmi.MarshalException;

public class MinFrogJumpstoReachIndex {
    public static void main(String[] args) {
        int n = 4;
        int[] a = {10,20,30,10};
        int dp[] = new int[n+1];
        //System.out.println(frogJumps(n-1,dp,a));

        //Using Tabulation
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            int fs = dp[i-1] + Math.abs(a[i] - a[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = dp[i-2] + Math.abs(a[i] - a[i-2]);

            dp[i] = Math.min(fs,ss);
        }
        System.out.println(dp[n-1]);
        System.out.println(frogJumps(n,a));

    }
        //Usinng Memorization
    public static int frogJumps(int ind, int[] dp,int[] a){
        if(ind == 0)
            return 0;
        int left = frogJumps(ind - 1,dp,a) +  Math.abs(a[ind] - a[ind - 1]);
        int right = Integer.MAX_VALUE;
        if(ind > 1)
            right = frogJumps(ind - 2,dp,a) + Math.abs(a[ind] - a[ind - 2]);
        return Math.min(left,right);
    }
    //Optimized
    public static int frogJumps(int n , int[] a){
        int prev = 0;
        int prev2 = 0;
        for(int i = 1;i<n;i++){
            int fs = prev + Math.abs(a[i] - a[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = prev2 + Math.abs(a[i] - a[i-2]);

            int curi  = Math.min(fs,ss);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
