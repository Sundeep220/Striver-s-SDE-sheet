package com.Sundeep;

import java.util.HashSet;

public class longest_consecutive_subsequence {
    public int longestConsecutive(int[] nums) {
        //USing HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i] - 1)){
                int count = nums[i]; //keeps track of number of conseccutive element
                while(set.contains(count))
                    count++;
                if(ans < count - nums[i])
                    ans = count - nums[i];
            }
        }
        return ans;
    }
}
