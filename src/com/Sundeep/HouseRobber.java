package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
    int[] a = {1,5,1,2,6};
        System.out.println(HouseRobber(a));
    }

    public static int HouseRobber(int[] HouseCash){
        int n = HouseCash.length;
        if(n == 1)
            return HouseCash[0];
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i != 0)
                temp1.add(HouseCash[i]);
            if(i != n-1)
                temp2.add(HouseCash[i]);
        }
        return Math.max(getMaxSum(temp1),getMaxSum(temp2));
    }

    public static int getMaxSum(ArrayList<Integer> a){
        int prev = a.get(0);
        int prev2 = 0;
        for(int i =1;i<a.size();i++){
            int pick = a.get(i);
            if(i > 1)
                pick += prev2;
            int notpick = prev;

            int ans = Math.max(pick,notpick);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }
}
