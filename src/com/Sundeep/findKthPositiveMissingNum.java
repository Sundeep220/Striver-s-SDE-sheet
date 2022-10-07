package com.Sundeep;

public class findKthPositiveMissingNum {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;
        int missingnums = compute(arr[end],end+1);
        while(start <= end){
            int mid = start + (end -start)/2;
            missingnums = compute(arr[mid],mid+1);
            if(missingnums < k)
                start = mid+1;
            else end = mid-1;
        }
        if(end == -1) return k;
        return arr[end] + k - compute(arr[end],end+1);
    }
    //Function to compute missing numbers
    //Since the array is sorted for n = 5 array should contain 1,2,3,4,5 as its elements to have 0 missing
    // elements but to find the missing elements we can do formula like a[n-1] - n
    public int compute(int actual,int expected){
        return actual - expected;
    }
}
