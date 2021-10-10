package com.zdh.home.algorithm.week01;


import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {


    public static void main(String[] args) {
        int[] heights={3,2,5,6,1,3};

        int i = largestRectangleArea(heights);
        System.out.println(i);
    }


    public static int largestRectangleArea(int[] heights) {

        heights = Arrays.copyOf(heights, heights.length + 1);
        Stack<Rect> stack = new Stack<>();
        int ans = 0;
        for (int height : heights) {
            int accumulateWidth = 0;
            while (!stack.empty() && height < stack.peek().getHeight()) {
                accumulateWidth += stack.peek().getWidth();
                ans = Math.max(ans, stack.peek().height * accumulateWidth);
                stack.pop();
            }
            stack.push(new Rect(accumulateWidth+1, height));
        }

        return ans;
    }

    public static class Rect {
        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }


    }
}
