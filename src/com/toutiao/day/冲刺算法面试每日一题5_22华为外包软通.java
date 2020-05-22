package com.toutiao.day;

/**
 * 移除指定元素
 * 简单
 * 华为外包软通
 */
public class 冲刺算法面试每日一题5_22华为外包软通 {

    public static void main(String[] args) {
        int []nums={3,2,4,3};
        int val=3;
        System.out.println(deleteStrOne(nums, val));
        System.out.println(deleteStrTwo(nums, val));
    }

    /**
     * 常规双指针
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    private static int  deleteStrOne(int[] nums, int val) {
        int left = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[left] = nums[j];
                left++;
            }
        }
        return left;

    }

    /**
     * 双指针- 当要删除的元素很少时
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    private static int  deleteStrTwo(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            } else {
                left++;
            }
        }
        return right;
    }


}


