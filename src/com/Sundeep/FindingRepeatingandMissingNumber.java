package com.Sundeep;

public class FindingRepeatingandMissingNumber {
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
}
