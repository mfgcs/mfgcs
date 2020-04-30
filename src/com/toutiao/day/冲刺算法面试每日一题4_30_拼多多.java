package com.toutiao.day;

import java.util.Arrays;

/**
 * 绝对差值
 * 中等
 * 拼多多机试算法题
 */
public class 冲刺算法面试每日一题4_30_拼多多 {

    public static void main(String[] args) {
        int []aNums={1,5,2};
        int []bNums={9,6,11};
        smallestDifference(aNums,bNums);
    }


    /**
     * 双指针法
     * @param aNums
     * @param bNums
     * @return
     */
    public static int smallestDifference(int[] aNums, int[] bNums) {
        Arrays.sort(aNums);
        Arrays.sort(bNums);
        int aLeft = 0, bLeft = 0;
        long res = Long.MAX_VALUE;
        while(aLeft < aNums.length && bLeft < bNums.length) {
            if(aNums[aLeft] <= bNums[bLeft]) {
                res = Math.min(res, (long) bNums[bLeft] - (long)aNums[aLeft]);
                aLeft++;
            } else {
                res = Math.min(res, (long)aNums[aLeft] - (long)bNums[bLeft]);
                bLeft++;
            }
        }
        return (int)res;
    }

    /**
     * 双指针优化方案
     * @param aNums
     * @param bNums
     * @return
     */
    public static int smallestDifference1(int[] aNums, int[] bNums) {
        long min =  Integer.MAX_VALUE;
        int aLeft = 0;
        int bLeft = 0;
        Arrays.parallelSort(aNums);
        Arrays.parallelSort(bNums);
        while(aLeft<aNums.length && bLeft<bNums.length) {
            if(min == 0)return 0;
            if(aNums[aLeft]<bNums[bLeft]) {
                while(aLeft<aNums.length &&aNums[aLeft]<bNums[bLeft]) {
                    aLeft++;
                }
                if(aLeft<aNums.length) {
                    min = Math.min(min, Math.abs((long)aNums[aLeft]-bNums[bLeft]));

                }
                min = Math.min(min, Math.abs((long)aNums[aLeft-1]-bNums[bLeft]));

            }else if(aNums[aLeft]>=bNums[bLeft]) {
                while(bLeft<bNums.length &&aNums[aLeft]>bNums[bLeft]) {
                    bLeft++;
                }
                if(bLeft<bNums.length) {
                    min = Math.min(min, Math.abs((long)aNums[aLeft]-bNums[bLeft]));

                }
                min = Math.min(min, Math.abs((long)aNums[aLeft]-bNums[bLeft-1]));
            }


        }
        return (int)min;
    }




}


