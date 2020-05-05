package com.toutiao.day;

/**
 * 连续最大乘积
 * 中等
 * 蚂蚁金服一面算法题
 */
public class 冲刺算法面试每日一题5_5蚂蚁金服 {

    public static void main(String[] args) {
    }


    /**
     * 常规DP解法
     * @param nums
     * @return
     */
    public int maxProductOne(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        dpMax[0] = nums[0];
        int[] dpMin  = new int[n];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    /**
     * 针对本题优化DP
     * @param nums
     * @return
     */
    public int maxProductTwo(int[] nums) {
        int max = Integer.MIN_VALUE, dpMax = 1, dpMin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = dpMax;
                dpMax = dpMin;
                dpMin = tmp;
            }
            dpMax = Math.max(dpMax*nums[i], nums[i]);
            dpMin = Math.min(dpMin*nums[i], nums[i]);

            max = Math.max(max, dpMax);
        }
        return max;
    }

}


