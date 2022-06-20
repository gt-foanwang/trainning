package com.company.leetcode;

public class Binary {
    public int search(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;
        while(left <= right){
                int pivot = left + (right-left)/2;
            if(nums[pivot]== target){
                return pivot;
            }
            if(target> nums[pivot]){
                left = pivot+1;
            }else{
                right = pivot-1;
            }
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {
        int start = 1;
        int end = nums.length-1;
        while(start<= end){
            int mid = start+(end-start)/2;
            if(nums[mid]== target){
                return mid;
            }else if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }
        }
        if(start<=end){
            return start-1;
        }else{
            return end+1;
        }
    }
}
