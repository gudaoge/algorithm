package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 直接选择排序
 * 每次从待排序的数组中选取最小的一个放到已排序数组的后面
 * 需要双重循环，时间复杂度O(n^2)
 * 使用固定数量的变量，空间复杂度O(1)
 * 会改变相同大小值的相对顺序，非稳定排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //每次循环从待排序的数组中选取一个最小值
        for (int i = 0; i < nums.length - 1; i++) {
            //取待排序数组中第一个
            int min = i;
            //向后循环比较找出最小的一个
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}
