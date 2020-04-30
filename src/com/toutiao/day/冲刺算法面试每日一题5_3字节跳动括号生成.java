package com.toutiao.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合括号
 * 中等
 * 字节跳动算法题
 */
public class 冲刺算法面试每日一题5_3字节跳动括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesisOne(3));
//        System.out.println(generateParenthesisTwo(4));
    }

    /**
     * DFS一
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesisOne(int n) {
        //定义返回有效括号的集合
        List<String> list = new LinkedList();
        //构造括号数组，因为括号都是成对的出现
        char[] chars = new char[n * 2];
        //定义chars数组下标
        int index = 0;
        //递归dfs
        dfs(list, chars, n, n, index);
        return list;
    }

    private static void dfs(List<String> list, char[] chars, int left, int right, int index) {
        if (left > right) return;
        if (left == 0 && right == 0) list.add(new String(chars));
        if (left > 0) {
            chars[index] = '(';
            // 思考！为什么不能使用下面的--left，++index
            dfs(list, chars, left - 1, right, index + 1);
//             dfs(list, chars, --left, right, ++index );
        }
        if (right > 0) {
            chars[index] = ')';
            dfs(list, chars, left, right - 1, index + 1);
//             dfs(list, chars, left, --right, ++index );
        }
        ;
    }

    /**
     * DFS2
     * @param n
     * @return
     */
    public static List<String> generateParenthesisTwo(int n) {
        List<String> list = new ArrayList<>();
        int left=n;
        int right=0;
        String str ="";
        dfs2(list, left, right, str);
        return list;
    }

    public static void dfs2(List<String> list, int left, int right, String str){
        if(left==0 && right==0){
            list.add(str);
        }else{
            if(left>0){
                dfs2(list,left-1,right+1,str+"(");
            }
            if(right>0){
                dfs2(list,left,right-1,str+")");
            }
        }
    }

}


