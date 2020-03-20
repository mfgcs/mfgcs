package com.toutiao.day;

/**
 * 题目：数组峰值问题
 * 难度：中等
 * 考察点：数组，线性扫描，递归，迭代二分查找
 * 企业面试题：互联网企业面试算法题型
 */
public class 冲刺算法面试每日一题3_20_数组峰值问题 {
    public static void main(String[] args) {
        int []nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
//        int []nums={1,2,3,4,5,6,7,8,9,10,11,33,13,14,15,16,17,18,19,20,21};
//        int []nums={21,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        long startTimeOne=System.currentTimeMillis();
        int max1 = findPeakElementOne(nums);
        System.out.printf("线性扫描：该数组的峰值是： %s \n",max1);
        long endTimeOne=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeOne-startTimeOne)/1000+"s");

        long startTimeTwo=System.currentTimeMillis();
        int max2 = findPeakElementTwo(nums);
        System.out.printf("递归二分法：该数组的峰值是： %s \n",max2);
        long endTimeTwo=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeTwo-startTimeTwo)/1000+"s");

        long startTimeThree=System.currentTimeMillis();
        int max3 = findPeakElementThree(nums);
        System.out.printf("迭代二分法：该数组的峰值是： %s \n",max3);
        long endTimeThree=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeThree-startTimeThree)/1000+"s");

    }


    /**
     * 线性扫描方式
     * 时间复杂度 : O(n)我们对长度为 n 的数组 nums 只进行一次遍历。
     * 空间复杂度 : O(1)只使用了常数空间。
     * @param nums
     * @return
     */
    public static int findPeakElementOne(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    /**
     * 递归二分法查找
     * 时间复杂度 :log_2(n)每一步都将搜索空间减半。因此，总的搜索空间只需要 log_2(n)步。其中n为nums数组的长度。
     * 空间复杂度: log_2(n)每一步都将搜索空间减半。因此，总的搜索空间只需要 log_2(n) 步。
     * 于是，递归树的深度为 log_2(n)
     * @param nums
     * @return
     */
    public static int findPeakElementTwo(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public static  int search(int[] nums, int left, int right) {
        if (left == right)
            return left;
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, left, mid);
        return search(nums, mid + 1, right);
    }

    /**
     * 迭代二分查找
     * 时间复杂度 :log_2(n)每一步都将搜索空间减半。因此，总的搜索空间只需要 log_2(n)步。其中n为nums数组的长度。
     * 空间复杂度 : O(1)只使用了常数空间。
     * @param nums
     * @return
     */
    public static int findPeakElementThree(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }


}
