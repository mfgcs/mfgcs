package com.toutiao.day;

/**
 * 字符串A转换为B最少步骤
 * 困难
 * 腾讯三面算法题
 */
public class 冲刺算法面试每日一题5_8腾讯三面 {

    public static void main(String[] args) {
        String strA = "mfgcs";
        String strB = "mso";
        System.out.println(minDistanceOne(strA, strB));
        System.out.println(minDistanceTwo(strA, strB));
    }

    /**
     * 动态规划（DP）
     * 状态转移方程
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     *
     * 其中，dp[i][j] 代表 A字符串从 0 到 i 位置
     * 转换成 B 字符串从 0 到 j 位置需要最少步数
     * dp[i-1][j-1] 表示替换操作，
     * M
     * M
     * dp[i-1][j] 表示删除操作，
     * dp[i][j-1] 表示插入操作。
     * @param strA
     * @param strB
     * @return
     */
    public static int minDistanceOne(String strA, String strB) {
        int lenA = strA.length();
        int lenB = strB.length();
        int[][] dp = new int[lenA + 1][lenB + 1];

        // 第一行 如果 A 串为空串，到B的编辑距离就是 j
        for (int j = 1; j <= lenB; j++) {
            dp[0][j] = j;
        }
        // 第一列 如果 B 串为空串，到B的编辑距离就是 i
        for (int i = 1; i <= lenA; i++){
            dp[i][0] = i;
        }

        //A 串中前 i 个
        for (int i = 1; i <= lenA; i++) {
            //B 串中前 j 个
            for (int j = 1; j <= lenB; j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
            }
        }
        return dp[lenA][lenB];
    }

    // 一维dp
    public static int minDistanceTwo(String strA, String strB) {
        int[] dp = new int[strB.length() + 1];
        for (int j = 1; j <= strB.length(); j++) {
            dp[j] = j; // 相当于给dp[0,j]赋值
        }
        for (int i = 1; i <= strA.length(); i++) {
            int pre = i - 1;//保存 [i-1,j-1]
            dp[0] = i; // 相当于给dp[i,0]赋值为i
            for (int j = 1; j <= strB.length(); j++) {
                int tmp = dp[j];
                if (strA.charAt(i - 1) == strB.charAt(j - 1))
                    dp[j] = pre;
                else
                    dp[j] = min(dp[j - 1] + 1, dp[j] + 1, pre + 1);
                pre = tmp;
            }
        }
        return dp[strB.length()];
    }

    /**
     * 求最小值
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int min(int a, int b, int c) {
        if (a > b)
            a = b;
        if (a > c)
            a = c;
        return a;
    }

}


