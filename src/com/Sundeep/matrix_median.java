package com.Sundeep;

public class matrix_median {
    public int findMedian(int[][] A) {
        int low = 1;
        int high = 1000000000;
        int n = A.length;
        int m = A[0].length;
        while(low <= high){
            int mid = (low+high) >> 1;
            int cnt = 0;
            for(int i=0;i<n;i++)
                cnt += countSmallerThanMid(A[i],mid);
            if(cnt <= (n*m)/2)
                low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    public int countSmallerThanMid(int[] a, int mid){
        int low = 0;
        int end = a.length-1;
        while(low <= end){
            int md = (low+end) >> 1;
            if(a[md] <= mid)
                low = md+1;
            else if(a[md] > mid)
                end = md-1;
        }
        return low;
    }
}
