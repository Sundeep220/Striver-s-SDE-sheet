package com.Sundeep;

public class singleNOduplicates {
    //Here we are using Binary search
    //Logic: Just search in that part of array which has odd number of elements as each element is repeated twice and
    //only one element is repeated, So one half of array must be odd.
    //But also ensure that nums[mid] is not at the repeated element .
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(mid < end && nums[mid] == nums[mid+1]){  //checking if mid is not the 2nd repeated element of that number
                mid = mid-1;
            }
            if((mid-start+1) % 2 == 0){
                //search for right part of array
                start = mid+1;
            }else end = mid;
        }
        return nums[start]; //or nums[end]
    }
}
