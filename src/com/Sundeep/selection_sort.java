package com.Sundeep;

import java.util.Arrays;

public class selection_sort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,3,7,9,51};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selection(int[] a){
        for(int i=0;i<a.length;i++){
            int last = a.length-i-1;
            int max = getMax(a,0,last);
            swap(a,max,last);
        }
    }

    public static void swap(int[] a, int max, int last) {
        int temp = a[max];
        a[max] = a[last];
        a[last] = temp;
    }

    public static int getMax(int[] a,int start,int end) {
        int max = start;
        for(int i=start;i<=end;i++){
            if(a[max] < a[i])
                max = i;
        }
        return max;
    }
}
