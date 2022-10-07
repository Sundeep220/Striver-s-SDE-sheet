package com.Sundeep;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }

    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        //Calculating n-1 factorial and storing the array elements
        for(int i=1;i<n;i++){
            fact *= i;
            numbers.add(i);
        }
        //adding the last number also
        numbers.add(n);
        k = k-1; //As it is zero based indexing
        String ans = "";
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0)
                break;

            //Update k and fact
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
