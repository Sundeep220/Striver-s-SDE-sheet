package com.Sundeep;

import java.util.ArrayList;
import java.util.List;

public class permutationsofArray {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
       // System.out.println(permute(nums));
        System.out.println(permute2(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        generatePermutations(nums,ds,res,freq);
        return res;
    }

    public static void generatePermutations(int[] a, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        //if the permutation list length is equal to orignal array length then we have found the permutation
        if(ds.size() == a.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        //check for every index elements after picking it
        for(int i=0;i<a.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(a[i]);
                generatePermutations(a,ds,ans,freq);
                //backtracking after recursive call
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }


    //Using swapping technique
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generatePermutations2(0,nums,res);
        return res;
    }

    public static void generatePermutations2(int ind, int[] a, List<List<Integer>> ans){
        if(ind == a.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<a.length;i++){
                ds.add(a[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }


        for(int i = ind; i<a.length;i++){
            swap(ind,i,a);
            generatePermutations2(ind+1,a,ans);
            //backtrack be reswapping
            swap(ind,i,a);
        }
    }

    public static void swap(int i, int j, int[] a){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    
}
