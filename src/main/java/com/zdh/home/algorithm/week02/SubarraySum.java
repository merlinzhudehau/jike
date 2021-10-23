package com.zdh.home.algorithm.week02;

import java.util.HashMap;

class SubarraySum {

    public static void main(String[] args) {
        int[] a = {1, 2,3};
        int i = subarraySum(a, 0);
        System.out.println(i);
    }

    public static int subarraySum(int[] nums, int k) {




        int ans = 0;
        int pre=0;
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if (counts.containsKey(pre - k)) {
                ans += counts.get(pre - k);

            }
                counts.put(pre, counts.getOrDefault(pre, 0) + 1);
            }


        return ans;
    }


}