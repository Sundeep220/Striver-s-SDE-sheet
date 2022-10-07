package com.Sundeep;


import java.util.Arrays;

public class cyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] a){
        int i=0;
        while(i < a.length){
            int correctIndex = a[i] - 1;
            if(a[i] != a[correctIndex]){
                swap(a,i,correctIndex);
            }else i++;
        }
    }
    public static void swap(int[] a, int start, int end){
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
