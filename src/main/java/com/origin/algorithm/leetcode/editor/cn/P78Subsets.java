/*
[78]子集
subsets
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P78Subsets {
    public static void main(String[] args) {
        //Solution solution = new P78Subsets().new Solution();
    }

    /**
     * 思路：
     * 假设给定[1]:
     * []
     * [1]
     * 假设给定[1,2]:
     * []
     * [1]
     *
     * [2]
     * [1,2]
     * 假设给定[1,2,3]:
     * []
     * [1]
     * [2]
     * [1,2]
     *
     * [3]
     * [1,3]
     * [2,3]
     * [1,2,3]
     *
     * 由推导可知
     * nums[0 ~ x] 可以由nums[0 ~ x-1]的子集加上nums[x]得到
     *
     * 解法2
     * 对于每个元素来说，在子集中的结果就是在或不在
     * 因此建立长度n位的掩码
     * 例如给定数组 [1,2,3] 掩码长度为3:
     * 000 --> [null,null,null]
     * 001 --> [null, null, 3]
     * ···
     * 111 --> [1, 2, 3]
     * 因此可以从0开始遍历，直到2的n+1次方-1
     *
     * TODO 回溯法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());

        for (int num : nums) {
            //获取之前的所有子集数量
            int size = ret.size();
            for (int i = 0; i < size; i++){
                //给每个子集加上当前元素作为新的子集
                List<Integer> temp = new ArrayList<>(ret.get(i));
                temp.add(num);
                ret.add(temp);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}