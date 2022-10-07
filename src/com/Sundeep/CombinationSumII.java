package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
            int a[] = {2,5,2,1,2};
        System.out.println(combinationSum2(a,5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private static void generateCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        //checking for subseqeuence
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i-1])continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            generateCombinations(i+1,arr,target - arr[i],ans,ds);
            ds.remove(ds.size()- 1);
        }
    }
}
