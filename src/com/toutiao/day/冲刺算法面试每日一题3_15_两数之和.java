package com.toutiao.day;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个目标值 target，
 * 在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
 * 难度：简单
 * 考察点：数组 哈希表
 * 企业面试题：中等企业中高级面试算法题型
 */
public class 冲刺算法面试每日一题3_15_两数之和 {
    public static void main(String[] args) {
        int [] nums={2,3,9,12};
        int target =15;
        long startTimeOne=System.nanoTime();
        int[] fun1 = twoSumFun1(nums, target);
        System.out.printf("暴力破解法：该数组中的索引为 %s %s \n",fun1[0],fun1[1]);
        long endTimeOne=System.nanoTime();
        System.out.println("执行时间："+(double)(endTimeOne-startTimeOne)/1000+"s");

        long startTimeTwo=System.nanoTime();
        int[] fun2 = twoSumFun2(nums, target);
        System.out.printf("两遍哈希表：该数组中的索引为 %s %s \n",fun2[0],fun2[1]);
        long endTimeTwo=System.nanoTime();
        System.out.println("执行时间："+(double)(endTimeTwo-startTimeTwo)/1000+"s");
        System.out.printf("一遍哈希表该如何做呢？");

    }

    /**
     * 暴力破解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumFun1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("此数组无目标解");
    }

    /**
     * 两遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumFun2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("此数组无目标解");
    }

    /**
     * 一遍哈希表该如何做？
     */

}
