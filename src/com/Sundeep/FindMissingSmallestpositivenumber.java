package com.Sundeep;

public class FindMissingSmallestpositivenumber {
    public int missingNumber(int[] a){
        int i=0;
        while(i < a.length){
            int correct = a[i] - 1;
            if(a[i] > 0 && a[i] <a.length && a[i] != a[correct]){
                swap(a,i,correct);
            }else i++;
        }
        for(int j=0;j<a.length;j++){
            if(a[j] != j+ 1 )
                return j+1;
        }
        return a.length+1;
    }
    public void swap(int[] a, int start, int end){
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
