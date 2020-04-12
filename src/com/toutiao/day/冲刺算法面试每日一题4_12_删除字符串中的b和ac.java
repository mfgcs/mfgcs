package com.toutiao.day;

/**
 * 题目：删除字符串中的b和ac
 * 难度：中等
 * 考察点：字符串数组，循环
 * 企业面试题：字节跳动初面，简单消消乐
 */
public class 冲刺算法面试每日一题4_12_删除字符串中的b和ac {
    public static void main(String[] args) throws Exception {
//        String str1="abaca";
        String str1 = "aaabbccc";
        deleteBAndAC(str1);

    }

    private static void deleteBAndAC(String str1) {
        char[] str = str1.toCharArray();
        int newLength = 0;
        int i = 0;
        String strTest="abaca";
        while (i != str.length) {
            if (str[i] != 'b') {
                str[newLength] = str[i];
                if (newLength == 0) {
                    newLength++;
                    i++;
                    continue;
                }
                if (str[newLength] == 'c' && str[newLength - 1] == 'a') {
                    newLength--;
                } else {
                    newLength++;
                }
            }

            i++;

        }
        System.out.println(str);
        System.out.println(newLength);
    }

}
