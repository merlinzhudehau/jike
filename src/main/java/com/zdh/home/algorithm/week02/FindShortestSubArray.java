package com.zdh.home.algorithm.week02;

import java.util.HashMap;
import java.util.Map;

class FindShortestSubArray {

    public static void main(String[] args) {
        int[] a=new int[]{1, 2, 2, 3, 1};
        int shortestSubArray = findShortestSubArray(a);
        System.out.println(shortestSubArray);

    }

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (counts.containsKey(nums[i])){
                counts.get(nums[i])[0]++;
                counts.get(nums[i])[2]=i;
            }else{
                counts.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum=0;
        int minlen=0;


        for (Map.Entry<Integer, int[]> integerEntry : counts.entrySet()) {
            Integer key = integerEntry.getKey();
            int[] value = integerEntry.getValue();
            if (maxNum<value[0]){
                maxNum=value[0];
                minlen=value[2]-value[1]+1;
            }else if (maxNum==value[0]){
                if (minlen > value[2] - value[1] + 1) {
                    minlen = value[2] - value[1] + 1;
                }
            }
        }


        return minlen;
    }


}

