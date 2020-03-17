package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 快速排序
 * 随便选取一个数作为中轴元素，将待排序数组划分为 小于中轴，大于等于中轴的两组
 * 对左右两个数组，继续进行上述操作
 * 时间复杂度O(nlogn)
 * 空间复杂度O(logn)
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //找到基准值的位置
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int start = left ;
        int end = right;
        while (start < end) {
            //右指针先走 找到小于等于基准值的
            while (start < end && nums[end] > pivot) {
                end --;
            }
            //左指针后走，找到大于基准值的
            while (start < end && nums[start] <= pivot) {
                start ++;
            }

            if (start < end) {
                swap(nums, start, end);
            }
        }
        //跳出循环的情况 右指针始终指向
        nums[left] = nums[end];
        nums[end] = pivot;
        return end;
    }

    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
