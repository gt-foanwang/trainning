package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class DataStructure {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> test = new HashSet<Integer>();
        for(int i =0;i< nums.length;i++){
            if(test.contains(nums[i])){
                return true;
            }else{
                test.add(nums[i]);
            }
        }
        return false;
    }
}
