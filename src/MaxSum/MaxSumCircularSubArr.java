package MaxSum;

import java.util.Scanner;

public class MaxSumCircularSubArr {
    static int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int maxSum=nums[0];
        int currMax=0;
        int minSum=nums[0];
        int currMin=0;

        for(int num:nums){
            currMax=Math.max(num,currMax+num);
            maxSum=Math.max(maxSum,currMax);

            currMin=Math.min(num,currMin+num);
            minSum=Math.min(minSum,currMin);

            total+=num;
        }
        if(maxSum<0)return maxSum;
        return Math.max(maxSum,total-minSum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.nextLine().trim().split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(maxSubarraySumCircular(nums));
    }
}
