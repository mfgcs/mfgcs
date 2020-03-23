package com.toutiao.day;

import com.toutiao.util.ZeroEvenOddOne;

import java.util.function.IntConsumer;

/**
 * 题目：交替打印零与奇偶数
 * 难度：中等
 * 考察点：多线程，并发，信号量，锁（管道模型）
 * 企业面试题：蚂蚁金服二面算法题
 */
public class 冲刺算法面试每日一题3_20_蚂蚁金服二面算法题 {
    public static void main(String[] args) throws Exception {
        try {
            ZeroEvenOddOne zeroEvenOdd = new ZeroEvenOddOne(20);
//            ZeroEvenOddTwo zeroEvenOdd = new ZeroEvenOddTwo(20);
//            ZeroEvenOddThree zeroEvenOdd = new ZeroEvenOddThree(20);
            IntConsumer intConsumer = value -> System.out.print(value);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.zero(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.odd(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.even(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 最简单的做法
     * @param nums
     */
   public static void zeroEvenOdd(int nums){
       if(nums==0){
           System.out.print(0);
       }
       for (int i = 1; i <= nums; i++)
       {
           System.out.print(0);
           System.out.print(i);
       }
   }

    /**
     * Semaphore ?
     * Semaphore是什么，跟synchronized有什么区别
     * IntConsumer？
     * IntConsumer是什么，跟Consumer有何关联
     * 借助信号量来建立屏障
     */

    /**
     * Lock
     * 凡是可以用信号量解决的问题，都可以用管程模型来解决
     * 管程模型是传说中的万能模型
     */

    /**
     * unLock
     * 学习过程中，但凡用了锁的，都可以尝试用无锁试试
     */

}
