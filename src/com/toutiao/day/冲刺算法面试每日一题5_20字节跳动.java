package com.toutiao.day;

import java.util.Scanner;

/**
 * 自动校对器
 * 简单
 * 字节跳动
 */
public class 冲刺算法面试每日一题5_20字节跳动 {

    public static void main(String[] args) {
        deleteStrOne();
//        deleteStrTwo();
    }

    /**
     * 正则表达式
     */
    private static void deleteStrOne() {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {//AAAAAABB--AABBCC--AABBC
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+", "$1$1").replaceAll("(.)\\1(.)\\2(.)\\3", "$1$1$2$2$3"));
        }
    }

    /**
     *  暴力破解，一次遍历即可
     */
    private static void deleteStrTwo() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(sc.nextLine());
                for (int j = 2; j < sb.length(); j++) {
                    //如果满足AAA+则直接删除一个
                    if (sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 1) == sb.charAt(j - 2)) {
                        sb.deleteCharAt(j);
                        j--;
                    } else if (isPattern(sb, j - 3, j)) {
                        //如果满足aabb则删除b
                        sb.deleteCharAt(j);
                        j--;
                    }
                }
                System.out.println(sb.toString());
            }
        }
        sc.close();
    }

    public static boolean isPattern(StringBuilder sb, int i, int j) {
        if (i < 0)
            return false;
        //如果满足aabb则删除b
        return sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(j - 1) == sb.charAt(j);
    }

}


