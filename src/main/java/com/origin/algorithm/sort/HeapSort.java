package com.origin.algorithm.sort;

import java.util.Arrays;

/**
 * Created by gudaoge on 2020-03-14
 * 堆排序
 * 先构建最大堆，再不停的删除堆顶元素到末尾，即构成升序序列
 * 分为构建堆和删除堆顶元素两部，总的时间复杂度为O(nlogn)
 * 空间复杂度O(1)
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 8, 1, 2};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //构建最大堆
        createHeap(nums);
        //将堆顶元素删除
        for (int i = 0; i < nums.length - 1; i++) {
            deleteTop(nums, 0, nums.length - i - 1);
        }
        return nums;
    }

    public static void createHeap(int[] nums) {
        //从底向上逐渐构建 依次选取所有的父节点
        //假设父节点为n，则左右节点为2n+1，2n+2， 因此（子节点-1）/ 2 即为父节点的位置
        //首先选取最后一个节点的父节点
        int length = nums.length;
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            adjust(nums, i, length);
        }
    }

    /**
     * 调整堆的平衡
     * @param nums
     * @param root  当前堆或子堆的根节点
     * @param length 堆的总大小，末尾元素索引+1
     */
    public static void adjust(int[] nums, int root, int length) {
        int temp = nums[root];
        //先取左节点
        int child = root * 2 + 1;
        if (child < length && nums[child] > temp) {
            //左节点大于父节点时
            if (child + 1 < length && nums[child + 1] > nums[child]) {
                //右节点大于左节点时
                //此时最大值为右节点
                child = child + 1;
            }
            //交换父子节点的值 交换完成后父节点为最大值
            swap(nums, root, child);
            //子节点交换后可能会破坏平衡 需要调整子树
            adjust(nums, child, length);

        } else if (child + 1 < length && nums[child + 1] > temp) {
            //此时右节点最大
            child = child + 1;
            swap(nums, root, child);
            adjust(nums, child, length);
        }
        //父节点最大，无需调整

    }

    /**
     * 删除堆顶元素
     * @param nums
     * @param root 堆顶元素索引
     * @param end  末尾元素索引
     */
    public static void deleteTop(int[] nums, int root, int end) {
        //删除堆顶元素需要将堆顶元素与最后一个元素交换
        swap(nums, root, end);
        //减小堆的大小，再重新调整堆的平衡
        adjust(nums, root, end);
    }

    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
