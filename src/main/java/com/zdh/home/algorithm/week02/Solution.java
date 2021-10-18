package com.zdh.home.algorithm.week02;

class Solution {

    public static void main(String[] args) {
//        int[] ints = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
//        int[] ints = {1,1,2,1,1};
//        int i = numberOfSubarrays(ints, 2);
//        System.out.println(i);

        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubarray(a);
        System.out.println(i);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1] % 2;
        }
        int[] count = new int[n + 1];

        int ans = 0;
        count[s[0]]++;
        for (int i = 1; i <= n; i++) {

            if (s[i] - k >= 0) {
                ans += count[s[i] - k];
            }
            count[s[i]]++;

        }
        return ans;

    }


    public static int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int[] preMin = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        preMin[0] = s[0];
        for (int i = 1; i < n; i++) {
            preMin[i] = Math.min(preMin[i - 1], s[i]);
        }

        int ans = -10000;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, s[i] - preMin[i - 1]);
        }
        return ans;
    }
}