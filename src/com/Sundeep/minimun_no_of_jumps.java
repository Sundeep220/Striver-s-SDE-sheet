package com.Sundeep;

public class minimun_no_of_jumps {
    public int jump(int[] nums) {
        int jumps = 1;
        int maxR = nums[0];
        int step = nums[0];
        if(nums.length <= 1)
            return 0;
        if(nums[0] == 0)
            return -1;
        for(int i=1;i<nums.length;i++){
            //Checking if we reached the end of array
            if(i == nums.length-1)
                return jumps;
            step--;
            maxR = Math.max(maxR,i+nums[i]);

            if(step == 0){
                jumps++;
                //Checking if the element is 0, in that case i > maxR return -1.
                if(i >= maxR)
                    return -1;
                //new step will be equal to maxR -  i
                step = maxR - i;
            }
        }
        return jumps;
    }
}
