package com.toutiao.day;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一、城市的最小面积
 * 二、圈地运动
 * 简单
 * 奇虎360合集
 */
public class 冲刺算法面试每日一题5_24奇虎360合集 {

    public static void main(String[] args) {
        //建城
        buildCity();
        //圈地
        enclosureMovement();
    }

    private static void enclosureMovement() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        //如果木棍小于3根，肯定不能实现
        if (nums.length <3){
            System.out.println(-1);
        }
        //条件： n-1边的和大于最长边，就能组成封闭多边形
        int sum = 0; //前N个数之和
        int max = Integer.MIN_VALUE;//前N个数中的最大值
        boolean flag = true;//标记是否能构成最小面积
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = max > nums[i] ? max : nums[i];
            //如果i > 1（如果不大于1，说明只有2条边，无论如何都构成不了的）
            //并且sum - max > max，即前N个中不含Max的值之和大于Max，说明找到了，直接返回
            //这个注意 + 1 ，因为i从0开始
            if (i > 1 && sum > 2 * max) {
                System.out.println(i + 1);
                flag=false;
                break;
            }
        }
        //遍历完所有都不存在则说明不存在
        if (flag){
            System.out.println(-1);
        }
    }

    private static void buildCity() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arrX = new long[n];
        long[] arrY = new long[n];
        for (int i = 0; i < n; i++) {
            long X = scanner.nextLong();
            long Y = scanner.nextLong();
            arrX[i] = X;
            arrY[i] = Y;
        }
        Arrays.sort(arrX);
        long x = arrX[n - 1] - arrX[0];
        Arrays.sort(arrY);
        long y = arrY[n - 1] - arrY[0];
        long square;
        if (x > y) {
            square = x * x;
        } else
            square = y * y;
        System.out.println(square);
    }

}


