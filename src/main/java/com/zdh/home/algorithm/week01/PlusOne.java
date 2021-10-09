package com.zdh.home.algorithm.week01;

public class PlusOne {
    public int[] plusOne(int[] digits) {

        int n= digits.length;
        for(int i=n; i>0;i--){
            if(digits[i-1]<9){
                digits[i-1]=digits[i-1]+1;
                return digits;
            }
            digits[i-1]=0;
        }

        int[] result=new  int[n+1];
        result[0]=1;
        return result;
    }
}
