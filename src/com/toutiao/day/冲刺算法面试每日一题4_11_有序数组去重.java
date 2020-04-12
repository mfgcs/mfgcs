package com.toutiao.day;

/**
 * 题目：有序数组去重
 * 难度：简单
 * 考察点：数组，双指针
 * 企业面试题：字节跳动一面有序数组去重算法题
 */
public class 冲刺算法面试每日一题4_11_有序数组去重 {
    public static void main(String[] args) throws Exception {
        int []nums={1,2,2,3,3,3,4,5,6,6,7};
        removeDuplicatesOne(nums);
        int []nums1={1,2,2,3,3,3,4,5,6,6,7};
        removeDuplicatesTwo(nums1);
    }

    /**
     * 暴力计算法
     * @param nums
     * @return
     */
    private static int removeDuplicatesOne(int[] nums) {
        if (nums.length==0) return 0;
        int newSize=1;
        for(int left=0;left<nums.length-1;left++){
            if (nums[left]!=nums[left+1]){
                nums[newSize-1]=nums[left];
                newSize++;
            }
        }
        if (nums[newSize-1]!=nums[nums.length-1]){
            nums[newSize-1]=nums[nums.length-1];
        }
        System.out.println(nums);
        System.out.println(newSize);
        return newSize;
    }

    /**
     * 双指针之快慢指针
     * @param nums
     * @return
     */
    int []nums1={1,2,2,3,3,3,4,5,6,6,7};
    private static int removeDuplicatesTwo(int[] nums) {
        if (nums.length==0) return 0;
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if (nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        System.out.println(slow+1);
        return slow+1;
    }
}
