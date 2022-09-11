package com.Sundeep;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_knapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a,Item b){
            double a1 = (double)a.value / (double)a.weight;
            double b1 = (double)b.value / (double)b.weight;

            if(a1 < b1) return 1;
            else if(a1 > b1) return -1;
            else return 0;
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, new ItemComparator());
        int curWeight = 0;
        double finalValue = 0;
        for(int i=0;i<n;i++){
            if(curWeight + arr[i].weight <= W){
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            }else {
                int remain = W - curWeight;
                finalValue += ((double)arr[i].value/(double)arr[i].weight) * remain;
                break;
            }

        }
        return finalValue;
    }



}
