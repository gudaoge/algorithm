/*
[295]数据流的中位数
find-median-from-data-stream
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计

*/


package com.origin.algorithm.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295FindMedianFromDataStream{
    public static void main(String[] args) {
//        Solution solution = new P295FindMedianFromDataStream().new Solution();
        // TO TEST
    }

    /**
     * 思路：
     * 要取中位数的话
     * 首先，需要对数据进行排序
     * 整数个数情况下，取最中间的两个元素的平均值
     * 奇数个数情况下，取最中间的一个元素
     * 因此需要有数据结构可以稳定定位到中间元素
     *
     *
     *
     * 这种情况首先想到使用两个堆，分别存放一半元素
     * 一个大根堆存放数据左半部分
     * 一个小根堆存放数据右半部分
     * 维护两个堆的大小之差不能超过1
     *
     * 若堆的总大小为偶数，则取两个堆定元素的平均值
     * 若堆的总大小为奇数，则取稍大的堆的堆顶元素
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    private PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder());

    private PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        //右堆的元素都大于等于top
        Integer top = rightHeap.peek();
        if (top != null && num < top) {
            leftHeap.offer(num);
        } else {
            rightHeap.offer(num);
        }
        //若两个堆不平衡了需要维护
        while (rightHeap.size() - leftHeap.size() > 1) {
            leftHeap.offer(rightHeap.poll());
        }
        while (leftHeap.size() - rightHeap.size() > 1) {
            rightHeap.offer(leftHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftHeap.size() < rightHeap.size()) {
            return rightHeap.peek();
        }
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        }
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}