package com.toutiao.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：回文数判断
 * 判断一个整数是否是回文数。
 * 难度：简单
 * 考察点：数字，边界
 * 企业面试题：一般互联网企业中级面试算法题型
 */
public class 冲刺算法面试每日一题3_17_回文数判断 {
    public static void main(String[] args) {
        int num=1111;
        long startTimeOne=System.currentTimeMillis();
        Boolean yesOrNo1 = isPalindromeOne(num);
        System.out.printf("暴力算法法：%s 是回文数吗？ 答案是 ： %s \n",num,yesOrNo1);
        long endTimeOne=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeOne-startTimeOne)/1000+"s");

        long startTimeTwo=System.currentTimeMillis();
        Boolean yesOrNo2 = isPalindromeTwo(num);
        System.out.printf("数学取巧算法：%s 是回文数吗？ 答案是 ： %s \n",num,yesOrNo2);
        long endTimeTwo=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeTwo-startTimeTwo)/1000+"s");

    }

    /**
     * 暴力算法
     * 字符串反转
     * @param x
     * @return
     */
    public static boolean isPalindromeOne(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    /**
     * 数学取巧算法
     * 后半取出段数字进行翻转
     * @param x
     * @return
     */
    public static boolean isPalindromeTwo(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }


}
