package com.Sundeep;

import java.util.HashMap;

public class subarrays_with_given_xor {
    public int solve(int[] A, int B) {
        //Using HashMap to store the frequency of prefix xor
        int cnt= 0,xorr = 0;
        int n = A.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++){
            xorr = xorr ^ A[i];
            if(freq.containsKey(xorr ^ B)){
                cnt += freq.get(xorr ^ B);
            }
            if(xorr == B){
                cnt++;
            }
            if(freq.containsKey(xorr)){
                freq.put(xorr, freq.get(xorr)+1 );
            }
            else freq.put(xorr,1);
        }
        return cnt;
    }
}
