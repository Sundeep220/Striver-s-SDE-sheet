package com.Sundeep;

public class majority_element_n_by_2 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int ans = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[ans]){
                count++;
            }else count--;
            if(count == 0){
                count = 1;
                ans = i;
            }
        }
        if(count >= 1)
            return nums[ans];
        return -1;
    }
}
