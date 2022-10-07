package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int[] b = {10,1,2,7,6,1,5};

        //System.out.println(combinationSum(a,7));

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private static void generateCombinations(int i,int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //if target - arr[i] >= 0 then pick the element
        if(arr[i] <= target){
            ds.add(arr[i]);
            generateCombinations(i,arr,target - arr[i],ans,ds);
            //backtrack
            ds.remove(ds.size() - 1);
        }

        // otherwise dont pick
        generateCombinations(i+1,arr,target,ans,ds);
    }



}
