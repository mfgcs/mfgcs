package com.toutiao.day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 回文串
 * 简单
 * 哈希表-栈
 */
public class 冲刺算法面试每日一题5_13回文串 {

    public static void main(String[] args) {
        String str="mfgcsmfg";
        System.out.println(isPermutePalindromeOne(str));
        System.out.println(isPermutePalindromeTwo(str));
    }

    /**
     * 哈希表详解
     * @param str
     * @return
     */
    public static boolean isPermutePalindromeOne(String str) {
        char[] chars = str.toCharArray();
        HashSet<Character> characters = new HashSet<Character>();
        for (Character character : chars) {
            if (characters.contains(character)){
                characters.remove(character);
            }else {
                characters.add(character);
            }
        }
        return characters.size()<=1;
    }


    /**
     * 栈详解
     * @param str
     * @return
     */
    public static boolean isPermutePalindromeTwo(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        Stack<Character> stack=new Stack<>();
        for (Character character : chars) {
            if(stack.contains(character)){
                stack.pop();
            }else {
                stack.push(character);
            }
        }
        return stack.isEmpty()||stack.size()==1;
    }
}


