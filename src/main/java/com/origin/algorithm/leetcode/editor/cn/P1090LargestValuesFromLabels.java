/*
[1090]受标签影响的最大值
largest-values-from-labels
//我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。 
//
// 我们从这些项中选出一个子集 S，这样一来： 
//
// 
// |S| <= num_wanted 
// 对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。 
// 
//
// 返回子集 S 的最大可能的 和。 
//
// 
//
// 示例 1： 
//
// 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
// 
//
// 示例 2： 
//
// 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
// 
//
// 示例 3： 
//
// 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
// 
//
// 示例 4： 
//
// 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
//输出：24
//解释：选出的子集是第一项，第二项和第四项。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= values.length == labels.length <= 20000 
// 0 <= values[i], labels[i] <= 20000 
// 1 <= num_wanted, use_limit <= values.length 
// 
// Related Topics 贪心算法 哈希表

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P1090LargestValuesFromLabels {
    public static void main(String[] args) {
        //Solution solution = new P1090LargestValuesFromLabels().new Solution();
    }

    /**
     * 思路：
     * 要使和最大，那么就需要尽可能选value大的n个数
     * 因此先对value排序，判断value对应的标签是否超出数量，不超过就选择该value
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[][] arr = new int[values.length][2];

        for (int i = 0; i < values.length; i++) {
            arr[i][0] = i;
            arr[i][1] = values[i];
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int res = 0;

        Map<Integer, Integer> used = new HashMap<>();

        for (int[] pair : arr) {
            if (num_wanted == 0) {
                break;
            }
            if (used.getOrDefault(labels[pair[0]], 0) < use_limit) {
                used.put(labels[pair[0]], used.getOrDefault(labels[pair[0]], 0) + 1);
                res += pair[1];
                num_wanted--;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}