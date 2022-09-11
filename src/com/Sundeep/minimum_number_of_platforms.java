package com.Sundeep;

import java.util.Arrays;

public class minimum_number_of_platforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        //Using two pointer approach
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0;
        int platform = 1;
        int result = 1;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                //if arrival time of one train = dep ime of other train the we gonna need a platform as stated in Ques.
                platform++;
                i++;
            }else if(arr[i] > dep[j]){
                platform--;
                j++;
            }
            if(platform > result)
                result = platform;
        }
        return result;

    }
}
