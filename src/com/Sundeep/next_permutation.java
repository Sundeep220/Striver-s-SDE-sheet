package com.Sundeep;

public class next_permutation {
    public void nextPermutation(int[] nums) {
        //Using the observation
        //1. Find the index value where the element at that index is less than value at index+1
        //If index found != -1 then:
        //2. Traverse the array from back as in step 1 and find the element that is greater than element found in step 1.
        //3. Swap these 2 elements
        //4.Reverse the array from index + 1 till the end ti get the next permutation.
        if(nums.length <= 1) return;
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0){
            int j = nums.length-1;
            while(nums[i] >= nums[j]) j--;
            swap(nums,i,j);
        }
        reverse(nums, i+1, nums.length-1);
    }

    public void swap(int[] a, int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void reverse(int[] a, int start, int end){
        while(start < end)
            swap(a,start++,end--);
    }
}
