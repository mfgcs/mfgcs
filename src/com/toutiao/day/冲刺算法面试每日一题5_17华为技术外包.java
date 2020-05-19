package com.toutiao.day;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数组中最小的k个值
 * 简单
 * 华为技术外包面试题
 */
public class 冲刺算法面试每日一题5_17华为技术外包 {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7,1, 3 };
        int k = 3;
        int[] minNumbers = minNumbersOne(nums, k);
        System.out.println(minNumbers);
    }

    /**
     * 优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] minNumbersOne(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> queue = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        //int[] nums = {5, 6, 7,1, 3 };
        for (int e : nums) {
            // 当前数字小于堆顶元素才会入堆
            if (queue.isEmpty() || queue.size() < k || e < queue.peek()) {
                queue.offer(e);
            }
            if (queue.size() > k) {
                queue.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[queue.size()];
        int j = 0;
        for (int e : queue) {
            res[j++] = e;
        }
        return res;
    }

    /**
     * 每次判断分治快排后的这堆数字是否大于小于k，如果是等于k则直接返回数组
     * @param nums
     * @param k
     * @return
     */
    public int[] minNumbersTwo(int[] nums, int k) {
        sort(nums, 0, nums.length - 1, k);
        int[] ret = new int[k];
        System.arraycopy(nums, 0, ret, 0, k);
        return ret;
    }

    private void sort(int[] arr, int l, int r, int k) {
        int pivot = pickPivot(l, r);
        pivot = partition(arr, l, r, pivot);
        int cnt = pivot - l + 1;
        if (cnt > k)
            sort(arr, l, pivot - 1, k);
        else if (cnt < k)
            sort(arr, pivot + 1, r, k - cnt);
    }

    private int partition(int[] arr, int l, int r, int p) {
        swap(arr, p, r);
        for (int i = l; i <= r - 1; i++) {
            if (arr[i] < arr[r]) {
                swap(arr, l++, i);
            }
        }
        swap(arr, l, r);
        return l;
    }

    private int pickPivot(int l, int r) {
        return (l + r) / 2;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}


