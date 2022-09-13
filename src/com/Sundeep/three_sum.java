package com.Sundeep;

import java.util.*;

public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        //Using 2 pointer method
        Arrays.sort(nums);
        List<List<Integer>> l = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
            //check if they are not duplicates otherwise skip them
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                int sum = 0 - nums[i];
                int low = i+1;
                int high = nums.length-1;
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        l.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        //skip duplicates if  any
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(high > low && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum)
                        high--;
                    else low++;
                }
            }
        }
        return l;
    }
}
