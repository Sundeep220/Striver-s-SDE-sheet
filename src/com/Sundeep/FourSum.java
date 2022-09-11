package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //Similar to 3 sum but using two loops
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        if(nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int target1 = target - nums[i];
            for(int j=i+1;j<nums.length;j++){
                int key = target1 - nums[j];
                int low = j+1;
                int high = nums.length-1;
                while(low < high){
                    if(nums[low] + nums[high] == key){
                        result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < key)
                        low++;
                    else high--;
                }
                while(j+1 < nums.length && nums[j+1] == nums[j]) j++;
            }
            while(i+1<nums.length && nums[i+1] == nums[i]) i++;
        }
        return result;
    }
}
