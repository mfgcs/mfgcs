package com.toutiao.day;

/**
 * 移动数组中的0到最后
 * 中等
 * 字节跳动面试题
 */
public class 冲刺算法面试每日一题4_26_移动数组中的0 {
    public static void main(String[] args) throws Exception {
        int [] nums={0,1,2,0,3,7,0,12};
        moveZeroesOne(nums);
        moveZeroesTwo(nums);
        System.out.println();
    }

    /**
     *双指针2次遍历
     * @param nums
     */
    public static void moveZeroesOne(int[] nums) {
//        if(nums==null) {
//            return;
//        }
        //第一次遍历的时候，flag指针记录非0的个数，只要是非0的统统都赋给nums[flag]
        int flag = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[flag++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=flag;i<nums.length;++i) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针一次遍历（可优化）
     * @param nums
     */
    public static void moveZeroesTwo(int[] nums) {
//        if(nums==null) {
//            return;
//        }
        //两个指针i和flag
        int flag = 0;
        for(int i=0;i<nums.length;++i) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[flag];
                nums[flag++] = tmp;
            }
        }
    }


}
