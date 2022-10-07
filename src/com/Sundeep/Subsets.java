package com.Sundeep;

import java.lang.reflect.Array;
import java.util.*;


public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2};
//        System.out.println(subset(arr));
//        List<List<Integer>> ans = subset(arr);
//        Collections.sort(ans, new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                if(o1.get(0) < o2.get(0))
//                    return -1;
//                else if(o1.get(0) > o2.get(0))
//                    return 1;
//                else return 0;
//            }
//        });
        System.out.println(subsetsWithDup(arr));
    }


    static List<List<Integer>> subset(int[] a){
        List<List<Integer>> outer = new ArrayList<>();

        //create a new list inside outer for every iterations
        outer.add(new ArrayList<>());

        for(int num: a){
            //get the size of outer list to add the num into it
            int n = outer.size();
            //for every i it will increase
            for(int i=0;i<n;i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                //create a copy and add the num in it.
                internal.add(num);
                //then add these list to outer.
                outer.add(internal);
            }
        }

        return outer;
    }

    //If we had duplicates in
    //but this gave wrong answer for 1,1,2,2;
    static List<List<Integer>> subsetDuplicates(int[] a){
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(a);
        //create a new list inside outer for every iterations
        outer.add(new ArrayList<>());
        int start = 0;
        int end =0;
        for(int i=0;i<a.length;i++){
            if(i > 0 && a[i] == a[i-1]) {
                start = end+1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j=start;j<n;j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                //create a copy and add the num in it.
                internal.add(a[i]);
                //then add these list to outer.
                outer.add(internal);
            }
        }

        return outer;
    }
    //Using Recursion and concept of picking and non-picking an element
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0,nums,new ArrayList<>(),ans);

        return ans;
    }

    public static void generateSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        //Adding the copy of this empty list to ans list.
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i != ind && nums[i] == nums[i-1])continue;
            ds.add(nums[i]);
            generateSubsets(i+1,nums,ds,ans);
            //after this recursion call remove the last element i.e., backtrack
            ds.remove(ds.size() - 1);
        }
    }

}
