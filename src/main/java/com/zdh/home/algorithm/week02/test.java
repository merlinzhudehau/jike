package com.zdh.home.algorithm.week02;


public class test {
    public static void main(String[] args) {
        int[][] a= {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(a);
        //,[],[],[]
        int i = numMatrix.sumRegion(2,1,4,3);
        int i1 = numMatrix.sumRegion(1,1,2,2);
        int i3 = numMatrix.sumRegion(1,2,2,4);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i3);
    }
}
