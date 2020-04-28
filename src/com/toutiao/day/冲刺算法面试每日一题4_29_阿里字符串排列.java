package com.toutiao.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 阿里字符串排列
 * 中等
 * 阿里面试题
 */
public class 冲刺算法面试每日一题4_29_阿里字符串排列 {

    //存放返回排列字符串
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String str="abc";
        String[] permutation = permutation(str);
        //打印出字符串数组
        Arrays.asList(permutation).stream().forEach((x)->{
            System.out.println(x);
        });
    }

    public static String[] permutation(String s) {
        char[] ori = s.toCharArray();
        helper(ori, 0);
        return list.toArray(new String[0]);
    }

    private static void helper(char[] all, int index) {
        if (index == all.length) {
            String s = new String(all);
            list.add(s);
        }
        for (int i = index; i < all.length; i++) {
            if (i == index) {   // 同一个下标，无需交换
                helper(all, index + 1);
                continue;
            }
            int k;
            for (k = i - 1; k >= index; k--) {    // 剔除重复,用数组比set更快
                if (all[k] == all[i]) break;
            }
            if (k != index - 1) continue;
            swap(all, i, index);
            helper(all, index + 1);
            swap(all, i, index);
        }
    }

    private static void swap(char[] all, int i, int j) {
        char tmp = all[i];
        all[i] = all[j];
        all[j] = tmp;
    }
}


