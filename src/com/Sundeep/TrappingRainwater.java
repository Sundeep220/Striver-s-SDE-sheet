package com.Sundeep;

public class TrappingRainwater {
    public static void main(String[] args) {
        int a[] = {4,2,0,3,2,5};
        System.out.println(totalRainWater(a));
    }
    //Other way: **MOST OPTIMAL**
    //Two pointer
    //T: o(N)
    //S: o(1)
    public static int totalRainWater(int[] a){
        int left = 0,right = a.length-1,maxLeft = 0,maxRight = 0;
        int res = 0;
        while(left <= right){
            if(a[left] <= a[right]){
                if(a[left] > maxLeft)
                    maxLeft = a[left];
                else res += maxLeft - a[left];

                left++;
            }else{
                if(a[right] > maxRight)
                    maxRight = a[right];
                else res += maxRight - a[right];

                right--;
            }
        }
        return res;
    }
    //One way : Using Array  preprocessing
    //T: o(N)
    //S: o(N)
    public static int rainwater(int A[],int n){
        int left[] = new int[n];
        int right[] = new int [n];
        left[0] = A[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],A[i]);
        }
        right[n-1] = A[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],A[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=(Math.min(left[i],right[i])-A[i]);
        }
        return ans;

    }
}
