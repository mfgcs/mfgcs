package com.toutiao.day;

/**
 * 爬楼梯
 * 简单
 * 动态规划详细图解题
 */
public class 冲刺算法面试每日一题5_9动态规划详细图解题 {

    public static void main(String[] args) {
        int n=5;
        System.out.println(climbStairsOne(n));
    }

    /**
     * dp详解
     * @param n
     * @return
     */
    public static int climbStairsOne(int n) {
        if (n<1)return 0;
        if (n==1)return 1;
        int []dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairsTwo(int n) {
        if (n<1)return 0;
        if (n==1)return 1;
        if (n==2)return 2;
        return climbStairsTwo(n-1)+climbStairsTwo(n-2);
    }


}


