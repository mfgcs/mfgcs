package com.toutiao.day;

/**
 * 题目：买卖股票的最佳时机
 * 难度：简单
 * 考察点：数组，动态规划
 * 企业面试题：互联网企业面试算法题型
 */
public class 冲刺算法面试每日一题3_19_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int []nums={7,1,5,3,6,4};
        long startTimeOne=System.currentTimeMillis();
        int max1 = maxProfitOne(nums);
        System.out.printf("暴力算法：该数组的最大利益是： %s \n",max1);
        long endTimeOne=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeOne-startTimeOne)/1000+"s");

        long startTimeTwo=System.currentTimeMillis();
        int max2 = maxProfitTwo(nums);
        System.out.printf("动态规划：该数组的最大利益是： %s \n",max2);
        long endTimeTwo=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeTwo-startTimeTwo)/1000+"s");

    }

    /**
     * 暴力算法
     * 我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。
     * 此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
     * @param
     * @return
     */
    public static int maxProfitOne(int nums[]) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int price = nums[j] - nums[i];
                if (price > max)
                    max = price;
            }
        }
        return max;
    }
    /**
     * 动态规划
     *
     * @param
     * @return
     */
    public static int maxProfitTwo(int nums[]) {
        int min = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i] - min > max)
                max = nums[i] - min;
        }
        return max;
    }


}
