package com.toutiao.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目：无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 难度：中等
 * 考察点：字符串，哈希表，双指针，滑动窗口
 * 企业面试题：软通，中软国际，阿里，华为外包等企业中高级面试算法题型
 */
public class 冲刺算法面试每日一题3_16_无重复字符的最长子串 {
    public static void main(String[] args) {
        String  strings="ajsdlknalqvweq";
        long startTimeOne=System.currentTimeMillis();
        int length1 = lengthOfLongestSubstringOne(strings);
        System.out.printf("暴力破解法：该字符串中最长子串的长度为 %s \n",length1);
        long endTimeOne=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeOne-startTimeOne)/1000+"s");

        long startTimeTwo=System.currentTimeMillis();
        int length2 = lengthOfLongestSubstringTwo(strings);
        System.out.printf("滑动窗口：该字符串中最长子串的长度为 %s \n",length2);
        long endTimeTwo=System.currentTimeMillis();
        System.out.println("执行时间："+(double)(endTimeTwo-startTimeTwo)/1000+"s");

    }

    /**
     * 暴力破解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringOne(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    /**
     * 要检查一个字符串是否有重复字符，我们可以使用集合。我们遍历字符串中的所有字符，
     * 并将它们逐个放入 set 中。在放置一个字符之前，我们检查该集合是否已经包含它。
     * 如果包含，我们会返回 false。
     * 循环结束后，我们返回 true。
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringTwo(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


}
