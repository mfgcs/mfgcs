package com.toutiao.day;

/**
 * 题目：旋转数组
 * 难度：中等
 * 考察点：数组，循环
 * 企业面试题：备战腾讯算法面试题，旋转数组
 */
public class 冲刺算法面试每日一题4_13_旋转数组 {
    public static void main(String[] args) throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int n = 3;
        rotateOne(nums, n);
        rotateTwo(nums, n);

    }

    /**
     * 暴力破解法
     *
     * @param nums
     * @param k
     */
    public static void rotateOne(int[] nums, int k) {
        int startNum, endNum;
        for (int i = 0; i < k; i++) {
            endNum = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                startNum = nums[j];
                nums[j] = endNum;
                endNum = startNum;
            }
        }
        System.out.println(nums);
    }

    /**
     * 反转法
     *
     * @param nums
     * @param k
     */
    public static void rotateTwo(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(nums);

    }

    /**
     * 反转指定长度的数组
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


}
