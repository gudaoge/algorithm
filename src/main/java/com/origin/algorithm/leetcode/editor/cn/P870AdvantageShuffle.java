/*
[870]优势洗牌
advantage-shuffle
//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心算法 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class P870AdvantageShuffle {
    public static void main(String[] args) {
        //Solution solution = new P870AdvantageShuffle().new Solution();
    }

    /**
     * 思路：
     * 尽可能的将略微大于B的A放到对应位置上
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] clone = B.clone();
        Arrays.sort(A);
        Arrays.sort(clone);

        Map<Integer, Deque<Integer>> map = new HashMap<>();

        Deque<Integer> remain = new LinkedList<>();

        int index = 0;

        for (int a : A) {
            if (a > clone[index]) {
                if (!map.containsKey(clone[index])) {
                    map.put(clone[index], new LinkedList<>());
                }
                map.get(clone[index]).addLast(a);
                index++;
            } else {
                remain.addLast(a);
            }
        }

        int[] res = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            Deque<Integer> deque = map.get(B[i]);
            if (deque != null && !deque.isEmpty()) {
                res[i] = deque.pollLast();
            } else {
                res[i] = remain.pollLast();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}