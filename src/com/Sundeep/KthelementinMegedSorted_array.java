package com.Sundeep;

public class KthelementinMegedSorted_array {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        int finalArray[]=new int[n+m];
        int i=0,j=0,t=0;
        while(i<n && j<m) {
            if(arr1[i]<arr2[j]) {
                finalArray[t++] = arr1[i++];
            }
            else {
                finalArray[t++] = arr2[j++];
            }
        }
        if(i<n) {
            while(i<n)
                finalArray[t++] = arr1[i++];
        }
        if(j<m) {
            while(j<m)
                finalArray[t++] = arr2[j++];
        }
        return finalArray[k-1];
    }
}
