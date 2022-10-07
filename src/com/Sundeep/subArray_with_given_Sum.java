package com.Sundeep;

import java.util.HashMap;

public class subArray_with_given_Sum {

    //This problem was actually;:
    //Given an array of integers nums and an integer k.
    // A continuous subarray is called nice if there are k odd numbers on it.
    //Return the number of nice sub-arrays.
    //But indirectly it was using subarry with given sum algorithm.
    public int numberOfSubarrays(int[] nums, int k) {
        //Changing all odd to 1 and even to 0
        for(int i=0;i<nums.length;i++){
            if((nums[i] & 1) == 1)
                nums[i] = 1;
            else nums[i] = 0;
        }
        //Now this problem is just calculating subarrays with given sum
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        int cursum = 0, count = 0;
        for(int i=0;i<nums.length;i++){
            cursum += nums[i];
            if(freq.containsKey(cursum - k)){
                count += freq.get(cursum-k);
            }

            freq.put(cursum, freq.getOrDefault(cursum,0)+ 1);
        }
        return count;
    }
}
