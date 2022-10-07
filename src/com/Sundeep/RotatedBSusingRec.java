package com.Sundeep;

public class RotatedBSusingRec {
    public static void main(String[] args) {
        int[] a = {5,6,7,8,9,1,2,3};
        System.out.println(search(a,9,0,a.length-1));
    }

    public static int search(int[] a,int target, int s, int e){
        if(s > e)
            return -1;

        int mid = s + (e-s)/2;
        if(a[mid] == target)
            return mid;

        //If not then check if 1st half is sorted or not
        if(a[s] <= a[mid]){
            //check if target lies in this range
            if(target >= a[s] &&  target <= a[mid])
            return search(a,target,s,mid-1);

            else return search(a,target,mid+1,e);
        }

        //If the target lies in right half range
        if(target >= a[mid] && target <= a[e]){
            return search(a,target,mid+1,e);
        }
        //If it doesn't then just search for fisrt half
        return search(a,target,s,mid-1);
    }
}
