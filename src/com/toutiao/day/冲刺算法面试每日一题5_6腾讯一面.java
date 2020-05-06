package com.toutiao.day;

/**
 * 连续最大和
 * 简单
 * 腾讯一面算法题
 */
public class 冲刺算法面试每日一题5_6腾讯一面 {

    public static void main(String[] args) {
//        Map map =new HashMap(10000);
        int []nums={-2,0,4,8,-1,-1};
        System.out.println(maxSubArrayOne(nums));
        System.out.println(maxSubArrayOne(nums));
    }


    /**
     * 常规DP解法
     * @param nums
     * @return
     */
    public static int maxSubArrayOne(int[] nums) {
        int res = nums[0];
        int sum = 0;
        int []nums1={-2,0,-1};
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }


    /**
     * 分治算法
     * @param nums
     * @return
     */
    public static int maxSubArrayTwo(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    private static int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return maxNums(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }


    private static int maxNums(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

}


