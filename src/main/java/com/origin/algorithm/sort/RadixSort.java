package com.origin.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gudaoge on 2020-03-14
 * 基数排序
 * 已最大值的位数为标准，从个位开始，直到最高位
 * 每次根据对应位的值将元素放入对应桶内，再恢复到原数组
 * 不停循环，直到最高位
 * 最后的数组就是有序的
 *
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] nums = new int[]{13, 925, 237, 542, 628, 171, 2};
        System.out.println(Arrays.toString(sort(nums)));
    }

    private static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //寻找最大值
        int max = nums[0];
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        //根据最大值的位数计算需要排序多少次
        int total = 1;
        while (max / 10 > 0) {
            max = max / 10;
            total++;
        }
        //创建10个桶
        List<List<Integer>> bucketList = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        //从低位开始
        for (int i = 0; i < total; i++) {
            int divisor = (int) Math.pow(10, i);
            for (int num : nums) {
                //得到对应位的数字，放到对应的桶内
                bucketList.get((num / divisor) % 10).add(num);
            }
            //再恢复到原数组
            int cur = 0;
            for (List<Integer> bucket : bucketList) {
                for (Integer s : bucket) {
                    nums[cur] = s;
                    cur++;
                }
                bucket.clear();
            }
        }
        return nums;
    }


}
