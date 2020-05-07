package com.toutiao.day;

/**
 * 数组加一
 * 简单
 * 百度初面算法题
 */
public class 冲刺算法面试每日一题5_7百度初面 {

    public static void main(String[] args) {
        int []nums={9,9};
        System.out.printf("", plusOne(nums));
        

    }

    /**
     * 数学取余
     * @param nums
     * @return
     */
    public static int[] plusOne(int[] nums) {
        int len = nums.length;
        for(int i = len - 1; i >= 0; i--) {
            nums[i]++;
            nums[i] %= 10;
            if(nums[i]!=0)
                return nums;
        }
        nums = new int[len + 1];
        nums[0] = 1;
        return nums;
    }

    /**
     * 判断是否为9
     * @param nums
     * @return
     */
    public static int[] plusTwo(int[] nums) {
        int len = nums.length;
        for(int i = len-1; i >= 0; i--){
            if(nums[i] == 9){
                nums[i] = 0;
            } else {
                nums[i] = nums[i] + 1;
                return nums;
            }
        }
        nums = new int[len + 1];
        nums[0] = 1;
        return nums;
    }




}


