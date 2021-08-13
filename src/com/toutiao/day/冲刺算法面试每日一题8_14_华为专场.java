package com.toutiao.day;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出键盘上一行字母组成的字符串
 * 简单
 * 敬畏键盘侠
 */
public class 冲刺算法面试每日一题8_14_华为专场 {
    static String PATTERN_ONE = "^((Q|q)|(W|w)|(E|e)|(R|r)|(T|t)|(Y|y)|(U|u)|(I|i)|(O|o)|(P|p))+$";
    static String PATTERN_TWO = "^((A|a)|(S|s)|(D|d)|(F|f)|(G|g)|(H|h)|(J|j)|(K|k)|(L|l))+$";
    static String PATTERN_THREE = "^((Z|z)|(X|x)|(C|c)|(V|v)|(B|b)|(N|n)|(M|m))+$";

    public static void main(String[] args) {
        String[] strs = {"mfgcs", "qwer", "dnf", "Nb", "Bnzz"};
        getStringsOne(strs);
        getStringsTwo(strs);
        getStringsThree(strs);
        getStringsFour(strs);
    }

    /**
     * 暴力法
     *
     * @param strs
     */
    public static void getStringsOne(String[] strs) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            if (s1.contains(String.valueOf(str.charAt(0)))) {
                boolean yes = true;
                for (int i = 1; i < str.length(); i++) {
                    if (!s1.contains(String.valueOf(str.charAt(i)))) {
                        yes = false;
                        break;
                    }
                }
                if (yes)
                    list.add(str);
            } else if (s2.contains(String.valueOf(str.charAt(0)))) {
                boolean yes = true;
                for (int i = 1; i < str.length(); i++) {
                    if (!s2.contains(String.valueOf(str.charAt(i)))) {
                        yes = false;
                        break;
                    }
                }
                if (yes)
                    list.add(str);
            } else {
                boolean yes = true;
                for (int i = 1; i < str.length(); i++) {
                    if (!s3.contains(String.valueOf(str.charAt(i)))) {
                        yes = false;
                        break;
                    }
                }
                if (yes)
                    list.add(str);
            }
        }
        list.forEach(e -> {
            System.out.println(e);
        });
    }

    /**
     * 暴力法二，优化版
     *
     * @param strs
     */
    public static void getStringsTwo(String[] strs) {
        //首先把3行键盘表示出来
        String[] lines = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        List<String> list = new ArrayList<>();
        //下面这个for循环用来一个个单词逐个判断
        for (int i = 0; i < strs.length; i++) {
            String temp = "";//定义一个临时的字符串来存储这3行的某一行
            int count = 0;//定义一个count来储存当前单词满足的字母个数
            //下面这个循环来遍历当前单词的每一个字母
            for (int j = 0; j < strs[i].length(); j++) {

                //如果当前单词的首字母在第某行，临时字符串temp就等于第某行
                if (lines[0].indexOf(strs[i].charAt(0)) != -1) {
                    temp = lines[0];
                } else if (lines[1].indexOf(strs[i].charAt(0)) != -1) {
                    temp = lines[1];
                } else {
                    temp = lines[2];
                }
                //前面已经知道这个单词是在第几行了，所以现在要遍历每个字母也是否在这一行
                //并且满足的单词个数count也要+1
                if (temp.indexOf(strs[i].charAt(j)) == -1) {
                    break;
                } else {
                    count++;
                }
                //如果满足的单词个数等于当前单词的长度
                if (count == strs[i].length()) {
                    list.add(strs[i]);
                }
            }
        }
        list.forEach(e -> {
            System.out.println(e);
        });
    }

    /**
     * 哈希表+2次遍历
     * @param strs
     */
    public static void getStringsThree(String[] strs) {
        //用长度为26的数组标识每个字母所在的行号
        int[] map = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> list = new ArrayList<String>();
        for(String str:strs){
            String tempStr = str.toUpperCase();
            //确定单词首字母所在行
            int temp = map[tempStr.charAt(0)-65];
            boolean flag = true;
            for(int i=1;i<tempStr.length();i++){
                //通过与首字母比较行号确定是否在同一行，不在同一行则排除这个单词
                if(temp != map[tempStr.charAt(i)-65]){
                    flag = false;
                    break;
                }
            }
            //循环完成之后，表面这个单词就是可以通过一行完成！
            if(flag) list.add(str);
        }
        list.forEach(e->{
            System.out.println(e);
        });
    }

    /**
     * 正则表达式
     * 效率较低，但是加分项
     * @param strs
     */
    private static void getStringsFour(String[] strs) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].matches(PATTERN_ONE) || strs[i].matches(PATTERN_TWO) || strs[i].matches(PATTERN_THREE)) {
                list.add(strs[i]);
            }
        }
        list.forEach(e -> {
            System.out.println(e);
        });
    }

}


