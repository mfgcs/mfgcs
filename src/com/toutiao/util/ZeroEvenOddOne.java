package com.toutiao.util;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Semaphore
 * IntConsumer
 * 借助信号量来建立屏障
 */
public class ZeroEvenOddOne
{
    public int nums;

    public ZeroEvenOddOne(int nums) {
        this.nums = nums;
    }


    Semaphore z = new Semaphore(1);
    Semaphore e = new Semaphore(0);
    Semaphore o = new Semaphore(0);

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i< nums; i++) {
            z.acquire();
            printNumber.accept(0);
            if((i&1)==0) {
                o.release();
            }else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i<= nums; i+=2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<= nums; i+=2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
