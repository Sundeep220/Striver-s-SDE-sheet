package com.Sundeep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majortiy_element_n_by_3 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        List<Integer> l = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mapElement : m.entrySet() ){
            if(mapElement.getValue() > nums.length /3){
                l.add(mapElement.getKey());
            }
        }
        return l;
    }
//    Approach + Intuition: In our code, we start with declaring a few variables:
//
//    num1 and num2 will store our currently most frequent and second most frequent element.
//    c1 and c2 will store their frequency relatively to other numbers.
//    We are sure that there will be a max of 2 elements which occurs > N/3 times because there cannot be if you do a simple math addition.
//    Let, ele be the element present in the array at any index.
//
//            if ele == num1, so we increment c1.
//            if ele == num2, so we increment c2.
//            if c1 is 0, so we assign num1 = ele.
//            if c2 is 0, so we assign num2 = ele.
//    In all the other cases we decrease both c1 and c2.
//    In the last step, we will run a loop to check if num1 or nums2 are the majority elements or not by running a for loop check.

    public static ArrayList < Integer > majorityElementOptimal(int[] nums) {

        int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            ans.add(number1);
        if (count2 > len / 3)
            ans.add(number2);
        return ans;
    }
}
