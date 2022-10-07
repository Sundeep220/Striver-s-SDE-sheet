package com.Sundeep;


public class Main {

    public static void main(String[] args) {
        //Bubble Sort
        int a[] = {20,35,-15,7,55,1,-22};
        /*for(int i = a.length-1;i>0;i--){  //i = last unsorted index
            for(int j=0;j<i;j++){
                if(a[j] > a[j+1])
                    swap(a,j,j+1);
            }
        }*/
        //Selection sort
        /*for(int i = a.length - 1;i>0;i--){
            int largest = 0;         // i:last unsorted index
            for(int j=1;j<=i;j++){
                if(a[j]>a[largest])
                    largest = j;

            }
            swap(a,largest,i);

        }*/
        //Insertion sort
       /* for(int f= 1;f<a.length;f++){   // f = fist unsorted index as in this sorting we assume that the first index(i.e., 0)  is sorted
            int ele = a[f];
            int i;
            for(i=f;i>0 && a[i-1]>ele;i--){
                a[i] = a[i-1];
            }
            a[i] = ele;
        }*/
        //Shell Sort: Variation in insertion Sort as in this sorting we use gap method
        for(int gap = a.length/2;gap>0;gap/=2){ // here gap = 7/2 =>3,Hence no. of iterations is 2  and in next iterations gap=3/2=>1 in which we basically perform insertion sort method to sort the aray elemnts
            for(int i = gap;i<a.length;i++){
                int ele = a[i];
                int j;
                for(j=i;j>=gap && a[j-gap]>ele;j-=gap)
                    a[j] = a[j-gap];
                a[j]= ele;
            }
        }

        for(int i:a)
            System.out.println(i);


    }
   /* public static void swap(int[] a,int i,int j){
        if(i==j)
            return;
        else {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }*/
}

