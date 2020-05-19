package com.toutiao.day;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 简单
 * 图森未来初面算法题
 */
public class 冲刺算法面试每日一题5_15滑动窗口 {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //定义遍历结果数组的指针，从0开始
        int n = 0;
        //定义结果数组
        int[] ans = new int[nums.length + 1 - k];
        //滑动数组遍历
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            //每次遍历从 i 到 i+k-1 的 k 个元素
            for (int j = i; j < i + k; j++) {
                max = max > nums[j] ? max : nums[j];
            }
            ans[n++] = max;
        }

        return ans;
    }

    /**
     * 双端队列
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindowTwo(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        //双端队列保存index
        Deque<Integer> deque = new LinkedList<>();
        for(int i =0;i<nums.length;++i){
            if(!deque.isEmpty() && deque.getFirst()<i-k+1)//保证滑动窗口范围
                deque.removeFirst();
            //如果当前值大于队列中的值，则队列中的值再无可能成为最大值，则删除
            while(!deque.isEmpty() && nums[i]>nums[deque.getLast()])
                deque.removeLast();
            //将当前值加入队列
            deque.addLast(i);
            //最大值永远是头部，保存。
            if(i-k+1>=0)
                res[i-k+1]=nums[deque.getFirst()];
        }
        return res;

    }

}


