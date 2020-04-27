package com.toutiao.day;

import java.util.HashMap;
import java.util.Map;

/**
 * 滴滴拼车
 * 中等
 * 滴滴面试题
 */
public class 冲刺算法面试每日一题4_27_滴滴拼车 {
    public static void main(String[] args) throws Exception {
        //trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
        int capacity=11;
        int[][]trips={{3,2,7},{3,7,9},{8,3,9}};
        System.out.println(carPoolingOne(trips,capacity));
        System.out.println(carPoolingTwo(trips,capacity));
    }

    /**
     *统计法，记录每个点的车上的人数即可
     * @param trips
     * @param capacity
     * @return
     */
    public static boolean carPoolingOne(int[][] trips, int capacity) {
        //统计每个点车上的人数
        //trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
        int[] current = new int[1001];
        for (int[] trip : trips) {
            current[trip[1]] += trip[0];
            current[trip[2]] -= trip[0];
        }
        if (current[0] > capacity) return false;
        for (int i = 1; i < 1001; ++i) {
            current[i] += current[i - 1];
            if (current[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    /**
     * 两个哈希表
     * @param trips
     * @param capacity
     * @return
     */
    public static boolean carPoolingTwo(int[][] trips, int capacity) {
        //上车点，上车人数
        Map<Integer,Integer> upPerson=new HashMap<>();
        Map<Integer,Integer> downPerson=new HashMap<>();
        //trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
        //left———right：整个行驶区间
        int left=trips[0][1],right=trips[0][2];
        for(int [] t:trips){
            //遇到上车点或者下车点相同，把它们的人数相加即可
            upPerson.put(t[1],upPerson.getOrDefault(t[1],0)+t[0]);
            downPerson.put(t[2],downPerson.getOrDefault(t[2],0)+t[0]);
            left=Math.min(left,t[1]);
            right=Math.max(right,t[2]);
        }
        int cur=0; //现在车上的人数
        for(int i=left;i<=right;i++){
            if(downPerson.containsKey(i))
                cur-=downPerson.get(i);
            if(upPerson.containsKey(i))
                cur+=upPerson.get(i);
            if(cur>capacity)
                return false;
        }
        return true;
    }

}
