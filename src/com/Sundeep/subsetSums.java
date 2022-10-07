package com.Sundeep;

import java.util.ArrayList;

public class subsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        if(N == 0 || arr.size() == 0 || arr == null)
            return null;

        ArrayList<Integer> ans = new ArrayList<>();
        subSet(arr,0,0,ans,N);
        return ans;
    }

    public void subSet(ArrayList<Integer> arr, int ind , int sum , ArrayList<Integer> subset, int N){
        //Base case if ind == n add the current obtained sum and return
        if(ind == N){
            subset.add(sum);
            return;
        }
        //Either take the element or not take it
        subSet(arr, ind+1,sum + arr.get(ind), subset,N);
        subSet(arr, ind+1,sum,subset,N);
    }
}
