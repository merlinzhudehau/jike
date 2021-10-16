package com.zdh.home.algorithm.week02;

class Solution {

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 1, 1};
        int i = numberOfSubarrays(ints, 3);
        System.out.println(i);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int oddCount = 0;
        int arr[] = new int[len + 2];
        //记录第oddCount个奇数的下标
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                arr[++oddCount] = i;//第++oddCount个奇数的下标是i
            }
        }
        arr[0] = -1;//左边界
        arr[oddCount + 1] = len;//右边界

        // arr[i]是窗口左边界
        // arr[i+k-1] 是窗口右边界
        // arr[i-1]是左边的上一个奇数，在此之后到arr[i]都可选
        // arr[i+k]是右边的下一个奇数，在此之前都arr[i+k-1]都可选
        //前面可选部分长度为arr[i]-arr[i-1]
        //后面可选部分长度为arr[i+k]-arr[i+k-1]
        //总的可能数等于前后可选的组合

        for (int i = 1; i + k < oddCount + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }
}