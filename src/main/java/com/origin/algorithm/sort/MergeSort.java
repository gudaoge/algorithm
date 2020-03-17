package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 归并排序
 * 思想是把大数组划分成两个子数组，分别对两个数组排序，再合并
 * 子数字也按照同样的方式划分排序再合并
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int left,  int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index1 = left;
        int index2 = mid + 1;
        int cur = 0;
        //双指针进行两个有序数组进行排序
        while (index1 <= mid && index2 <= right) {
            if (nums[index1] < nums[index2]) {
                temp[cur] = nums[index1];
                cur++;
                index1++;
            } else {
                temp[cur] = nums[index2];
                cur++;
                index2++;
            }
        }

        //假设两个数组长度不一 排序完后还会剩下一个数组的部分元素没放到临时数组中
        while (index1 <= mid) {
            temp[cur] = nums[index1];
            index1++;
            cur++;
        }
        while (index2 <= right) {
            temp[cur] = nums[index2];
            index2++;
            cur++;
        }
        //临时数组再放回原数组
        for (int i = 0; i < temp.length; i++) {
            nums[left] = temp[i];
            left++;
        }

    }
}
