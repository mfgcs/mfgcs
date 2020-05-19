package com.toutiao.day;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * 删除字符串中出现次数最少的字符
 * 简单
 * 华为技术校招面试题
 */
public class 冲刺算法面试每日一题5_18华为校招面试 {

    public static void main(String[] args) {
        String s = "aabbccdd";
        System.out.println(deleteMinChar(s));
    }

    private static String deleteMinChar(String s) {
        //创建一个hashMap存储，存储字符串中的字符和其出现的次数
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            //如果hm集合中已经有这个键，则存入时直接将值加1
            hm.put(ch[i],hm.getOrDefault(ch[i],0)+1);
//            if (hm.containsKey(ch[i])) {
//                hm.put(ch[i], hm.get(ch[i]) + 1);
//            } else {
//                hm.put(ch[i], 1);
//            }
        }
        Collection<Integer> values = hm.values();
        Integer min = Collections.min(values);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (hm.get(ch[i]) != min) {
                str.append(ch[i]);
            }
        }
        return str.toString();
    }

}


