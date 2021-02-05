package com.ninggc.nettydemo.a;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 0, 3, 2};
        System.out.println(new Main().findMaxAverage(nums, 1));

        // new SoftRefer
    }

    public double findMaxAverage(int[] nums, int k) {

        long max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        long currentSum = max;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            if (currentSum > max) {
                max = currentSum;
            }
        }

        return 1.0 * max / k;
    }

}
