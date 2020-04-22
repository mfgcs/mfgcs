package com.toutiao.day;

import com.toutiao.util.UsetTest;

import java.util.HashSet;
import java.util.Set;

/**
 * 内存泄露场景
 */
public class 冲刺算法面试每日一题4_17_内存泄露场景 {
    public static void main(String[] args) throws Exception {
        UsetTest ut = new UsetTest();
        ut.setName("张三");
        Set set = new HashSet();
        set.add(ut);
        System.out.println(ut.hashCode());
        System.out.println(set.contains(ut));
        ut.setName("李四");
        System.out.println(ut.hashCode());
        System.out.println(set.contains(ut));
        System.out.println(set.remove(ut));

    }
}
