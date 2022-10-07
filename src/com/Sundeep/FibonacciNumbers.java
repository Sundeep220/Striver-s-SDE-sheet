package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n+1];

        //System.out.println(fib(n,dp));
        //System.out.println(fibTab(n,dp));
        System.out.println(fib(n));

    }
    //Using memorization
    public static int fib(int n,int[] dp){
        if(n <= 1)
            return n;
        if(dp[n] != -1)
            return dp[n];

        return dp[n] = (fib(n-1,dp) + fib(n-2,dp));
    }

    //Using Tabulation
    public static int fibTab(int n,int[] dp){
        int i;
        dp[0] = 0;
        dp[1] = 1;
        for(i=2;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }

    //Most Optimal
    public static int fib(int n){
        int a = 0,b= 1,c;
        if(n == 0)
            return a;
        if(n == 1)
            return b;
        for(int i=2;i<=n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
