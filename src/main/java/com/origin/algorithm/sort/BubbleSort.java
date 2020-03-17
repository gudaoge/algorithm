package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 冒泡排序
 * 两两比较，大值后移
 * 每次将待排序数组的中最大值移到待排序数组的末尾
 * 需要双重循环，时间复杂度O(n^2)
 * 使用固定数量的变量，空间复杂度O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //每趟都能排序一个最大值，一共需要n-1趟
        for (int i = 0; i < nums.length - 1; i++) {
            //第一趟开始时，已排序数组为0，
            //所以每趟开始时，已经排序的数组长度为趟数-1 = i，待排序数组长度为n-i
            //每趟比较时，前一个跟后一个比较，总共需要比较 m-1次，m为待排序数组长度
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
