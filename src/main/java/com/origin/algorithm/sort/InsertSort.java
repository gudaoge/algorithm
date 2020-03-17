package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 插入排序
 * 每次从待排序数组中选取第一个，插入到已排序数组中
 * 需要双重循环，时间复杂度O(n^2)
 * 使用固定数量的变量，空间复杂度O(1)
 *
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j;
            //每次从待排序数组中选第一个
            for (j = i - 1; j >= 0; j--) {
                //如果待排序的数小于已排序数组的数，就交换位置
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;

        }
        return nums;
    }

}
