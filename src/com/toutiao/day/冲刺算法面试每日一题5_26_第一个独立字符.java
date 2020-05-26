package com.toutiao.day;

import java.util.*;

/**
 * 第一个独立字符
 * 简单
 * 小米科技笔试题，用数组或哈希表实现，并分析优劣性
 */
public class 冲刺算法面试每日一题5_26_第一个独立字符 {

    public static void main(String[] args) {
        String str = "aacddee";
        System.out.println(firstCharOne(str));
        System.out.println(firstCharTwo(str));
        System.out.println(firstCharThree(str));

    }

    /**
     * 哈希表
     *
     * @param str
     * @return
     */
    public static char firstCharOne(String str) {
        //定义哈希表
        Map<Character, Boolean> map = new HashMap<>();
        char []chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            if (map.containsKey(chars[i])) {
//                map.put(chars[i], false);
//            } else {
//                map.put(chars[i], true);
//            }
            map.put(chars[i],!map.containsKey(chars[i]));
        }
        for (char c : str.toCharArray()) {
            if (map.get(c)) {
                return c;
            }
        }
        //没有独立的字符就返空
        return ' ';
    }

    /**
     * 有序哈希表
     * 当字符串长度很大的时候
     *
     * @param str
     * @return
     */
    public static char firstCharTwo(String str) {
        //定义有序哈希表
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), !map.containsKey(str.charAt(i)));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        //没有独立的字符就返空
        return ' ';
    }

    /**
     * 数组
     *
     * @param str
     * @return
     */
    public static char firstCharThree(String str) {
        //定义数组字典，Ascii一般7位有128字符，最大有256字符
        int[] dict = new int[256];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            dict[c]++;
        }
        for (char c : chars) {
            if (dict[c] == 1) {
                return c;
            }
        }
        //没有独立的字符就返空
        return ' ';
    }

}


