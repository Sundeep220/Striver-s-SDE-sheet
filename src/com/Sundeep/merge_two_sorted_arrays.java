package com.Sundeep;

public class merge_two_sorted_arrays {
    public void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] res = new int[m+n];
        while(i+j < m+n && i < m && j < n){
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                i++;k++;
            }else {
                res[k] = nums2[j];
                j++;k++;
            }

        }
        while(i < m){
            res[k] = nums1[i];
            i++;k++;
        }
        while(j<n){
            res[k] = nums2[j];
            k++;j++;
        }
        System.arraycopy(res,0,nums1,0,m+n);

    }
}
