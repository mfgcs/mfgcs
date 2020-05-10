package com.toutiao.day;

/**
 * 剪绳子
 * 中等
 * 动态规划-剪绳子
 */
public class 冲刺算法面试每日一题5_11动态规划剪绳子 {

    public static void main(String[] args) {
        int n=5;
        System.out.println(cutRopeOne(n));
        System.out.println(cutRopeTwo(n));
    }

    /**
     * dp详解
     * @param n
     * @return
     */
    public static int cutRopeOne(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }

    /**
     *贪心算法
     * @param n
     * @return
     */
    public static int cutRopeTwo(int n) {
        int max=Integer.MIN_VALUE;
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n%3==0){
            max=(int)Math.pow(3,n/3);
        }else if(n%3==1){
            max=2*2*(int)Math.pow(3,(n-4)/3);
        }else{
            max=2*(int)Math.pow(3,(n-2)/3);
        }
        return max;
    }

}


