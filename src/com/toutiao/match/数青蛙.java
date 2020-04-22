package com.toutiao.match;

/**
 * 字节跳动专场竞赛第一题：数青蛙
 * 中等
 */
public class 数青蛙 {
    public static void main(String[] args) {
        String croakOfFrogs="crcroaoakk";
        System.out.println(minNumberOfFrogsOne(croakOfFrogs));
        System.out.println(minNumberOfFrogsTwo(croakOfFrogs));
    }


    /**
     * 消消乐解法
     * @param croakOfFrogs
     * @return
     */
    public static int minNumberOfFrogsOne(String croakOfFrogs) {
        //croakOfFrogs="crcroaoakk";
        char[] chars = croakOfFrogs.toCharArray();
        if (chars.length < 5 || chars[chars.length - 1] != 'k'||chars[0] != 'c') {
            return -1;
        }
        int maxFrogs = 0;
        int c = 0, r = 0, o = 0, a = 0;
        for (char ch : chars) {
            switch (ch) {
                case 'c':
                    c++;
                    break;
                case 'r':
                    r++;
                    if (r > c) {
                        return -1;
                    }
                    break;
                case 'o':
                    o++;
                    if (o > r) {
                        return -1;
                    }
                    break;
                case 'a':
                    a++;
                    if (a > o) {
                        return -1;
                    }
                    break;
                case 'k':
                    maxFrogs = Math.max(maxFrogs, c);
                    c--;r--;o--;a--;
                    break;
            }
        }

        if (c + r + o + a > 0) {
            return -1;
        }
        return maxFrogs;
    }

    /**
     * 第一名的思路
     * 核心
     * if(c < 0 || r < 0 || o < 0 || a < 0)break;
     *
     * @param croakOfFrogs
     * @return
     */
    public static int minNumberOfFrogsTwo(String croakOfFrogs) {
        int c,r,o,a,k;
        c = 0; r = 0; o = 0; a = 0;k = 0;
        char []chars = croakOfFrogs.toCharArray();
        int res = 0;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == 'c'){
                if(k > 0){k--;}else{res++;}
                c++;
            }else if(chars[i] == 'r'){
                c--;r++;
            }else if(chars[i] == 'o'){
                r--;o++;
            }else if(chars[i] == 'a'){
                o--;a++;
            }else if(chars[i] == 'k'){
                a--;k++;
            }
            if(c < 0 || r < 0 || o < 0 || a < 0){
                break;
            }
        }
        if(c != 0 || r != 0 || o != 0 || a != 0){
            return -1;
        }
        return res;
    }
}


