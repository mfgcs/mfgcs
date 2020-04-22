package com.toutiao.day;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目：翻转字符串里的单词
 * 难度：中等
 * 考察点：字符串，双指针，集合，工具类的使用
 * 企业面试题：字节跳动 翻转字符串里的单词
 */
public class 冲刺算法面试每日一题4_15_翻转字符串里的单词 {
    public static void main(String[] args) throws Exception {
        String str ="the sky is blue";
        System.out.println(reverseWordsOne(str));
        System.out.println(reverseWordsTwo(str));
    }

    /**
     * 工具类解法
     * @param s
     * @return
     */
    public static String reverseWordsOne(String s) {
        String[] str = s.split("\\s+");
        List<String> strLists = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strLists);
//        StringBuilder sb=new StringBuilder();
//        for (int i = 0; i <strLists.size(); i++) {
//            sb.append(strLists.get(i));
//            if (i!=str.length-1){
//                sb.append(" ");
//            }
//        }
//        StringJoiner sj=new StringJoiner(" ");
//        for (int i = 0; i <strLists.size(); i++) {
//            sj.add(strLists.get(i));
//        }
        return String.join(" ",strLists);

    }

    /**
     * 双指针之左右指针
     * @param s
     * @return
     */
    public static String reverseWordsTwo(String s) {
        String[] str = s.split("\\s+");
        int left=0;
        int right=str.length-1;
        while (left<right){
            String temp=str[left];
            str[left]=str[right];
            str[right]=temp;
            left++;
            right--;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <str.length ; i++) {
            sb.append(str[i]);
            if (i!=str.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
