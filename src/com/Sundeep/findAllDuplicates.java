package com.Sundeep;

import java.util.ArrayList;
import java.util.List;

public class findAllDuplicates {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,4,2,5,6,6};
//        List<Integer> ans = findDuplicates(a);
//        System.out.println(ans);
        System.out.println(findDuplicate(a));
    }
    public static List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index+1) {
                ans.add(arr[index]);
            }
        }

        return ans;
    }
    public static int findDuplicate(int[] nums) {
        //Using Cyclic sort
        int i=0;
        while(i < nums.length){
            if(nums[i] != i+1){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums,i,correct);
                }else return nums[i];
            }
            else i++;
        }
        return -1;
    }

    static  void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
