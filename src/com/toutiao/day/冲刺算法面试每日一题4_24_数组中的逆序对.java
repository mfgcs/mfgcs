package com.toutiao.day;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * 阿里笔试题
 */
public class 冲刺算法面试每日一题4_24_数组中的逆序对 {
    public static void main(String[] args) throws Exception {
        int []nums ={10,5,3,2,4,1};
        System.out.println(reversePairs(nums));
    }

    public static  int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        //顺便给大家复习一下数据拷贝的五种常用方式
        //数组的拷贝方式一，遍历赋值
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            newNums[i] = nums[i];
        }
        //数组的拷贝方式二,数组工具类，（被拷贝的数组，拷贝的个数）
        int[] temps2 = Arrays.copyOf(nums, nums.length);
        //数组的拷贝方式二,数组工具类，（被拷贝的数组，数组起始位置，拷贝的个数）
        int[] temps3 = Arrays.copyOfRange(nums, 0,nums.length);
        //数组的拷贝方式四,系统工具类，（被拷贝的数组，起始位置，目标数组，起始位置，个数）
        int[] temps4 =new int[nums.length];
        System.arraycopy(nums,0,temps4,0,nums.length);
        //数组的拷贝方式五,clone，
        int[] temps5 = newNums.clone();

        int[] temp = new int[len];
        return reversePairs(newNums, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            // 有下标访问，得先判断是否越界
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里是 <= ，写成 < 就不对，请思考原因
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
                count += (mid - i + 1);
            }
        }
        return count;
    }

}
