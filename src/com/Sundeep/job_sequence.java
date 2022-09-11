package com.Sundeep;

import java.util.Arrays;

public class job_sequence {
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a, b) -> (b.profit - a.profit));
        int maxdeadline = 0;
        for(int i=0;i<n;i++){
            if(arr[i].deadline > maxdeadline){
                maxdeadline = arr[i].deadline;
            }
        }

        int[] ans = new int[maxdeadline + 1];

        for(int i=1;i<=maxdeadline;i++){
            ans[i] = -1;
        }

        int cntJobs=0,maxProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(ans[j] == -1){
                    ans[j] = i;
                    cntJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{cntJobs,maxProfit};
    }
}
