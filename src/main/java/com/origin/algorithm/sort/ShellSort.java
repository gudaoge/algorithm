package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 希尔排序
 * 是插入排序的变种，主要为了解决最大值靠前，需要挪动较多次数的情况
 * 思想是分段排序，选取一个步进，不停的缩小，直至为1
 * 希尔排序的时间复杂度证明比较复杂，结果是 O(n^(1.3—2))
 * 空间复杂滴O(1)
 * 分组交换过程可能会导致元素相对位置改变，所以是非稳定排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2, 5, 12, 6};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //初始选取一个步进，不停缩小
        for (int i = nums.length/ 2; i >= 1; i = i/2) {
            //根据步进分为n组，交替处理每组的数据，n，n+1，n+2，而不是处理完一组再处理下一组
            for (int j = i; j < nums.length; j++) {
                insertSort(nums, j, i);
            }
        }
        return nums;
    }

    public static void insertSort(int[] nums, int start, int k) {
        //进行插入排序 当前元素为待排序元素，当前元素之前的为已排序元素
        int temp = nums[start];
        int i;
        for (i = start - k; i >= 0; i = i - k) {
            if (nums[i] > temp) {
                nums[i + k] = nums[i];
            } else {
                break;
            }
        }
        nums[i + k] = temp;
    }



}
