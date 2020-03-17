package com.origin.algorithm.sort;

import java.util.*;

/**
 * Created by gudaoge on 2020-03-14
 * 桶排序
 * 找出数组的最大值和最小值 按一定的大小间隔划分为k个桶
 * 每个桶内放入大小处于 [min + n * d, min + (n + 1) * d) 的元素 n为桶的顺序 d为间隔
 * 再对每个桶内元素进行排序
 * 最后依次将每个桶内元素放回元素数组
 * 时间复杂度O(N+C)，其中C=N*(logN-logM) m为桶的个数
 * 空间复杂度O(N+K) k为桶的个数
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //核心思想是把数据划分为区间，每个区间对应一个桶，桶内排序
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        //选定桶内元素的大小间隔，暂定5
        int bucketNum = (max - min) / 5 + 1;
        //初始化桶
        List<List<Integer>> bucketList = new ArrayList<List<Integer>>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        //将所有元素放入对应的桶
        for (int i : nums) {
            bucketList.get((i - min) / 5).add(i);
        }
        //桶内排序
        for (List<Integer> bucket : bucketList) {
            Collections.sort(bucket);
        }
        int cur = 0;
        //将桶内元素放入原数组
        for (List<Integer> bucket : bucketList) {
            for (Integer i : bucket) {
                nums[cur] = i;
                cur++;
            }
        }
        return nums;
    }

}
