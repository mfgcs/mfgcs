package com.toutiao.match;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 竞赛第一题：按要求格式化字符串
 * 简单
 */
public class 按要求格式化字符串 {
    public static void main(String[] args) {

        String strOne = strFormatOne();
        String strTwo = strFormatOne();
        System.out.println(strOne);
        System.out.println(strTwo);
    }

    private static String strFormatOne() {
        String str = "mfgcs1234";
        char[] chars = str.toCharArray();
        List a=new ArrayList();
        List b=new ArrayList();
        StringBuilder sb=new StringBuilder();
        String res="";
        int left = 0;
        while (left < chars.length) {
            char temp = chars[left];
            if (temp >='a'&& temp <='z') {
                a.add(temp);
            } else {
                b.add(temp);
            }
            left++;
        }
        int strNum=a.size();
        int intNum = b.size();
        if (Math.abs(strNum-intNum)<=1){
            if (strNum>intNum){
                for (int i = 0; i <a.size()-1 ; i++) {
                    sb.append(a.get(i));
                    sb.append(b.get(i));
                }
                sb.append(a.get(a.size()-1));
                res=sb.toString();
            }else if(strNum<intNum){
                for (int i = 0; i <b.size()-1 ; i++) {
                    sb.append(b.get(i));
                    sb.append(a.get(i));
                }
                sb.append(b.get(b.size()-1));
                res=sb.toString();
            }else {
                for (int i = 0; i <b.size() ; i++) {
                    sb.append(b.get(i));
                    sb.append(a.get(i));
                }
                res=sb.toString();
            }

        }else {
            return res;
        }
        return res;
    }

    public String strFormatTwo() {
        String str = "mfgcs1234";
        Queue<Character> ch = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i) <='z'){
                ch.add(str.charAt(i));
            }else{
                num.add(str.charAt(i) - '0');
            }
        }
        if(Math.abs(ch.size() - num.size())>1){//不满足格式化的条件
            return "";
        }
        //谁长，就从谁开始
        if(ch.size() > num.size()){//字母长
            while(!ch.isEmpty() && !num.isEmpty()){
                res.append(ch.poll());
                res.append(num.poll());
            }
            //最后还剩一个ch
            while(!ch.isEmpty()){
                res.append(ch.poll());
            }

        }else{
            //数字长
            while(!ch.isEmpty() && !num.isEmpty()){
                res.append(num.poll());
                res.append(ch.poll());
            }
            while(!num.isEmpty()){
                res.append(num.poll());
            }
        }

        return res+"";
    }
}

