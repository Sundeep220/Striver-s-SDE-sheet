package com.Sundeep;

public class sort_arrays_of_zeros_one_and_twos {
    public void sortColors(int[] nums) {
        //Using Dutch Natinal Flag algorithm
        int l = 0 , mid = 0, high = nums.length-1;
        int t;
        while(mid <= high){
            switch(nums[mid]){
                case 0: //swap mid and l
                    t = nums[l];
                    nums[l] = nums[mid];
                    nums[mid] = t;
                    l++;
                    mid++;
                    break;
                case 1: mid++;
                    break;
                case 2: t = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = t;
                    high--;
                    break;
            }
        }

    }
}
