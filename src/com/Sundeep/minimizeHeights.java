package com.Sundeep;

import java.util.Arrays;

public class minimizeHeights {
    public static void main(String[] args) {
        int[] a = {3, 9, 12, 16, 20};
        System.out.println(getMinDiff(a,3));
    }
    public static int getMinDiff(int[] a, int k){
        int n = a.length;
        Arrays.sort(a);
        int min = a[0];
        int max = a[n-1];
        int res = max - min;

        for(int i=1;i<n-1;i++){
            max = Math.max(a[i-1] + k,a[n-1] - k);
            min = Math.min(a[i] - k,a[0] + k);

            res = Math.max(res, max - min);

        }
        return res;
    }
}
