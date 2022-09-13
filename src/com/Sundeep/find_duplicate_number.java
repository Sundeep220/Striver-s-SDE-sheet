package com.Sundeep;

public class find_duplicate_number {
    public int findDuplicate(int[] nums) {
        //Using Cyclic sort
        int i=0;
        while(i < nums.length){
            if(nums[i] != i+1){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums,i,correct);
                }else return nums[i];
            }
            else i++;
        }
        return -1;
    }

    public void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public int findDuplicateUsingFastandSlow(int[] nums) {
        int slow = 0;
        int fast = 0;

        //Using the concept of cycle detection
        //Imagining the array as linked list where
        //for e.g: a=[1,3,4,2,2]
        // can be interpreted as :
        //0->1
        // 1->3
        // 2->4
        // 3->2
        // 4->2
        // or 0->1->3->2->4->2->4->2->…
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
    public int findDuplicateUsingBS(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
