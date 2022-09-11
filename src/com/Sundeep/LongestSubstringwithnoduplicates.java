package com.Sundeep;

import java.util.HashMap;

public class LongestSubstringwithnoduplicates {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        if(s == null || s.length() < 1)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1 , left);
            }
            //otherwise update the map for current character in HAshMap
            map.put(s.charAt(right), right);
            maxL = Math.max(maxL, right - left + 1);
            right++;

        }
        return maxL;
    }
}
