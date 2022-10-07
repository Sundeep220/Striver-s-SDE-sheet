package com.Sundeep;

import java.util.Arrays;

public class bubble_sort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,3,7,9,51};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubble(int[] a){
        boolean swapped;
        //run the steps for n-1 time
        for(int i=0;i<a.length;i++){
            swapped = false;
            for(int j=1;j<a.length - i;j++){
                if(a[j] < a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    swapped = true;
                }
                if(!swapped)
                    break;
            }
        }
    }
}
