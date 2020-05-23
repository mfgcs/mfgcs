package com.toutiao.day;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 判读给定的数是否是丑数/找出小于N的所有丑数
 * 简单/中等
 * 字节跳动初面算法
 */
public class 冲刺算法面试每日一题5_23丑数 {

    public static void main(String[] args) {
        System.out.println(isUglyOne(8));
        System.out.println(isUglyTwo(8));

//        思考题解决方案
//        1, 2, 3, 4, 5, 6, 8, 9, 10, 12 为前10的丑数
//        System.out.println(nthUglyNumberOne(8));
//        System.out.println(nthUglyNumberTwo(8));

    }

    /**
     * 正常思维
     * @param num
     * @return
     */
    private static boolean  isUglyOne(int num) {
        if (num==0 )return false;
        while (num!=1){
            if (num%2==0){
                num/=2;
            }else if (num%3==0){
                num/=3;
            }else if (num%5==0){
                num/=5;
            }else {
                return false;
            }
        }
        return true;

    }

    /**
     * 递归法
     * @param num
     * @return
     */
    public static boolean isUglyTwo(int num) {
        if(num==0) return false;
        if(num==1) return true;
        return (num % 2==0 && isUglyTwo(num/2))
            || (num % 3==0 && isUglyTwo(num/3))
            || (num % 5==0 && isUglyTwo(num/5));
    }

    /**
     * 优先队列解决 思考问题
     *原理：集合&优先队列形成记录表
     * @param n
     * @return
     */
    public static int nthUglyNumberOne(int n) {
        // 集合&队列
        HashSet<Long> res = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        //定义为丑数的质因数数组
        int []factor = new int[]{2, 3, 5};
        int i=1;
        res.add(1L);
        queue.offer(1L);
        while(true){
            long e = queue.poll();
            if(i == n){
                return (int)e;
            }
            i++;
            for(int f: factor){
                if(!res.contains(e*f)){
                    res.add((long)e*f);
                    queue.offer((long)e*f);
                }
            }
        }
    }

    /**
     * 动态规划
     * 初始状态： dp[0] = 1 ，即第一个丑数为1 ；
     * 返回值： dp[n-1] ，即返回第n个丑数。
     * 状态转移方程：dp[i]=min(dp[a]×2,dp[b]×3,dp[c]×5)
     * 时间复杂度 O(N)： 其中 N =n ，动态规划需遍历计算 dp列表。
     * 空间复杂度 O(N)： 长度为 N的dp列表使用 O(N)的额外空间。
     * @param n
     * @return
     */
    public static int nthUglyNumberTwo(int n) {
        // 动态规划求解
        long []dp = new long[n];
        dp[0] = 1;
        int p1 = 0, p2=0, p3=0;
        for(int i=1; i<n; ++i){
            dp[i] = Math.min(dp[p1]*2, Math.min(dp[p2]*3, dp[p3]*5));
            // 确定生成丑数的来源, 非互斥关系
            if(dp[i] == 2*dp[p1])
                p1++;
            if(dp[i] == 3*dp[p2])
                p2++;
            if(dp[i] == 5*dp[p3])
                p3++;
        }


        return (int)dp[n-1];
    }

}


