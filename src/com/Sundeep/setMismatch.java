package com.Sundeep;

import java.util.Arrays;

public class setMismatch {
    public static void main(String[] args) {
        int a[] = {1,2,3,3,5,6,7};
        //System.out.println(Arrays.toString(findErrorNums(a)));
        System.out.println(Arrays.toString(repeatedNumber(a)));
    }
    public static int[] findErrorNums(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return new int[] {arr[index], index+1};
            }
        }
        return new int[] {-1, -1};
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    //Using Maths
    public static int[] repeatedNumber(final int[] A) {
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
