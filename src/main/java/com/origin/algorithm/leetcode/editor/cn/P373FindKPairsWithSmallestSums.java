/*
[373]查找和最小的K对数字
find-k-pairs-with-smallest-sums
//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆

*/
package com.origin.algorithm.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class P373FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        //Solution solution = new P373FindKPairsWithSmallestSums().new Solution();
    }

    /**
     * 暴力解法：
     * 穷举所有的和，然后排序取topK
     * 这种解法没有利用到升序数组这个条件
     * 时间复杂度O（n^2(logK)）
     * 空间复杂度O（K）
     *
     * 考虑到数组为升序
     * 那么:
     * nums1[a]+num2[b] < num[a+1]+num2[b] < num[a+x]+num2[b]
     * nums1[a]+num2[b] < num[a]+num2[b+1] < num[a]+num2[b+x]
     * 假设a,b的和最小，那么接下来最小的数只会是a+1，b或者a，b+1中的一个
     * 所以可以构建一个集合，保存所有候选对
     * 每次从集合中取出一个和最小的候选对，并加入该候选对的后面两个候选对
     *
     * TODO 实现类似264题丑数的解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int a = nums1[o1.getKey()] + nums2[o1.getValue()];
                int b = nums1[o2.getKey()] + nums2[o2.getValue()];
                if (a != b) {
                    return a - b;
                }
                // 相等的情况根据索引排序，使得重复的对放在一起
                if (o1.getKey().intValue() != o2.getKey().intValue()) {
                    return o1.getKey() - o2.getKey();
                }

                return o1.getValue() - o2.getValue();
            }
        });
        heap.add(new Pair<>(0, 0));

        List<List<Integer>> result = new ArrayList<>();
        Pair<Integer, Integer> last = null;
        while (result.size() < k && !heap.isEmpty()) {
            Pair<Integer, Integer> pair = heap.poll();
            if (last != null) {
                if (pair.getKey().equals(last.getKey()) && pair.getValue().equals(last.getValue())) {
                    //说明重复了 不是需要的结果集
                    continue;
                }
            }
            result.add(Arrays.asList(nums1[pair.getKey()], nums2[pair.getValue()]));
            last = pair;

            //当前对处理完了，将后续的两个对放入
            if (pair.getKey() + 1 < nums1.length) {
                heap.add(new Pair<>(pair.getKey() + 1, pair.getValue()));
            }
            if (pair.getValue() + 1 < nums2.length) {
                heap.add(new Pair<>(pair.getKey(), pair.getValue() + 1));
            }

        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}