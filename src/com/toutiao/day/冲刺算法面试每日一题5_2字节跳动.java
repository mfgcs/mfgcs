package com.toutiao.day;

import java.util.Stack;

/**
 * 有效的括号
 * 中等
 * 字节跳动高频算法题
 */
public class 冲刺算法面试每日一题5_2字节跳动 {

    public static void main(String[] args) {
        String str = "()[(]{}";
        int nums=3;

        System.out.println(isValid(str));
    }


    /**
     * 堆栈巧解法
     * @param str
     * @return
     */
    public static boolean isValid(String str) {
        if (str.isEmpty()) return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        return stack.empty();
    }


}


