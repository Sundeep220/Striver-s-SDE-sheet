package com.Sundeep;

import java.util.HashMap;

public class LargestSubarraywithsumZERO {
    int maxLen(int arr[], int n)
    {
        // Your code here
        int cursum = 0;
        int maxL = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            cursum += arr[i];
            if(cursum == 0){
                maxL = i+1;
            }else if(map.containsKey(cursum)){
                maxL = Math.max(maxL,i-map.get(cursum));
            }
            else map.put(cursum,i);
        }
        return maxL;
    }
}
