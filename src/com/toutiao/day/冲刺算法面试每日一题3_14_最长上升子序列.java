package com.toutiao.day;

import java.util.Arrays;

/**
 * 题目：求出给定数组中，最长上升子序列
 * 难度：中等
 * 考察点：动态规划 二分查找
 * 企业面试题：华为
 */
public class 冲刺算法面试每日一题3_14_最长上升子序列 {
    public static void main(String[] args) {
        int [] nums={10,9,2,5,3,7,101,18};
        long startTimeOne=System.nanoTime();
        System.out.printf("动态规划：该数组最长上升子序列长度为 %s \n",lengthOfLISOne(nums));
        long endTimeOne=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeOne-startTimeOne)/1000+"");

        long startTimeTwo=System.nanoTime();
        System.out.printf("动态规划+二分查找：该数组最长上升子序列长度为 %s \n",lengthOfLISTwo(nums));
        long endTimeTwo=System.nanoTime();
        System.out.println("执行时间："+(double)(endTimeTwo-startTimeTwo)/1000+"");
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int lengthOfLISOne(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 动态规划 + 二分查找
     * 时间复杂度O(NlogN)
     * @param nums
     * @return
     */
    public static int lengthOfLISTwo(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) {
                res++;
            }
        }
        return res;
    }
}
