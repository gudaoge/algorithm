package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 计数排序
 * 适合最大值和最小值差别不是很大的场合
 * 把数组元素作为临时数组的下标，存储数组元素出现的次数
 * 时间复杂度O(n+k) k为临时数组大小
 * 需要用到额外大小为k的数组，空间复杂度O(k)
 */
public class CountSort {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max=nums[i];
            }
        }
        int[] temp = new int[max + 1];
        for (int j = 0; j < nums.length; j++) {
            temp[nums[j]] ++;
        }
        int cur = 0;
        for (int k = 0; k < temp.length; k++) {
            for (int m = 0; m < temp[k]; m++) {
                nums[cur] = k;
                cur++;
            }
        }
        return nums;
    }
}
