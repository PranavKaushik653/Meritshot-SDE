package Histogram;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInHistogram {

    static int largestRectangle(int height[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = height.length;

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && height[i]<height[stack.peek()]){
                int h=height[stack.pop()];
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                maxArea=Math.max(maxArea,h*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h=height[stack.pop()];
            int width=stack.isEmpty()?n:n-stack.peek()-1;
            maxArea=Math.max(maxArea,h*width);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().trim().split(" ");
        int[] heights = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            heights[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(largestRectangle(heights));
    }
}
