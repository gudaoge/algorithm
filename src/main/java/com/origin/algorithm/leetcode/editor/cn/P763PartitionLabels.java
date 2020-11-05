/*
[763]划分字母区间
partition-labels
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P763PartitionLabels {
    public static void main(String[] args) {
        //Solution solution = new P763PartitionLabels().new Solution();
    }

    /**
     * 思路：
     * 记录每个字母出现的最后坐标
     * 该字母出现的第一个坐标和最后坐标必须在一个片段
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];

        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ret = new ArrayList<>();

        int index = 0;
        int maxPos = 0;
        int lastMaxPos = -1;
        while (index < S.length()) {

            while (index <= maxPos) {
                int lastPos = lastIndex[S.charAt(index) - 'a'];
                maxPos = Math.max(lastPos, maxPos);
                index++;
            }
            ret.add(maxPos - lastMaxPos);

            lastMaxPos = maxPos;
            maxPos = index;

        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}