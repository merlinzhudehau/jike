package com.zdh.home.algorithm.week02;

import java.util.HashMap;

public  class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                ints[1]=i;
                ints[0]=hashMap.get(nums[i]);
            }
            hashMap.put(target-nums[i],i);
        }
        return ints;

    }
}