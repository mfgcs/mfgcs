package com.toutiao.day;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：判断一个给定的数是不是快乐数
 * 难度：中等
 * 考察点：数学，哈希表，双指针
 * 企业面试题：新华三一面算法题
 */
public class 冲刺算法面试每日一题3_31_新华三一面算法题 {
    public static void main(String[] args) throws Exception {
        int num=19;
        String formatOne = String.format("哈希表判断这个数num=%s是快乐数吗？？答案是：%s", num,isHappyOne(num));
        String formatTwo = String.format("快慢双指针判断这个数num=%s是快乐数吗？？答案是：%s", num, isHappyTwo(num));
        System.out.println(formatOne);
        System.out.println(formatTwo);
    }

    /**
     * 求一个数的各给位的平方和
     * @param num
     * @return
     */
    private static int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * 哈希表
     * @param num
     * @return
     */
    public static boolean isHappyOne(int num) {
        Set<Integer> seen = new HashSet<>();
        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            num = getNext(num);
        }
        return num == 1;
    }

    /**
     * 之快双指针慢指针
     * @param num
     * @return
     */
    public static boolean isHappyTwo(int num) {
        int slow = num;
        int fast = getNext(num);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }



}
