package com.Sundeep;

public class Kedane_algorithm {
    public int maxSubArray(int[] nums) {
        //Using kedanes algorithm
        int max = Integer.MIN_VALUE;
        int cursum = 0;
        for(int i=0;i<nums.length;i++){
            cursum += nums[i];
            if(cursum > max)
                max = cursum;
            if(cursum < 0)
                cursum = 0;
        }
        return max;
    }
}
