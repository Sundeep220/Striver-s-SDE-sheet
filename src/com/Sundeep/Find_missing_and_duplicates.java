package com.Sundeep;

public class Find_missing_and_duplicates {
    public int[] repeatedNumber(final int[] A) {
        long n = A.length;
        long expectedSum = n * (n+1)/2;
        long expectedSquareSum = n * (n+1) * (2*n+1) / 6;

        //Using Maths
        //if we subtract the actual sum of elements in array with the expected sum we would get the value of B - A
        //Similarly for sum of squares we get value of B^2 - A^2
        for(int i=0;i<n;i++){
            expectedSum -= (long)A[i];
            expectedSquareSum -= (long)A[i] * A[i];
        }

        int missingNum = (int)(expectedSum + expectedSquareSum/expectedSum) / 2;
        int repeatingnum = (int)missingNum - (int)expectedSum;
        return new int[]{repeatingnum, missingNum};

    }
    public int[] findMissingANdDuplicates(int[] a){
        //Using Cyclic sort
        int i=0;
        while(i < a.length){
            int correct = a[i] - 1;
            if(a[i] != a[correct])
                swap(a,i,correct);
            else i++;
        }
        for(int j = 0;j<a.length;j++){
            if(a[j] != j+1)
                return new int[]{a[j],j+1};
        }
        return new int[]{-1,-1};
    }

    public void swap(int[] a, int start, int end){
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
