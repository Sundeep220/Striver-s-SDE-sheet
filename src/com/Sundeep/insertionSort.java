package com.Sundeep;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,3,7,9,51};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertion(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(a[j] < a[j-1]){
                    swap(a, j, j - 1);
                }else
                    break;
            }
        }
    }
    public static void swap(int[] a, int max, int last) {
        int temp = a[max];
        a[max] = a[last];
        a[last] = temp;
    }
}
