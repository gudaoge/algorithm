/*
[461]汉明距离
hamming-distance
//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算

*/


package com.origin.algorithm.leetcode.editor.cn;

public class P461HammingDistance{
    public static void main(String[] args) {
        // Solution solution = new P461HammingDistance().new Solution();
        // TO TEST
    }

    /**
     * 思路:
     * 逐一判断每位是否相同
     * 那么需要32次迭代，每次迭代涉及到x，y的bit判断
     *
     * 可以直接将x，y进行异或
     * 判断结果中1的个数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        int ret = 0;
        while (m != 0) {
            m = m & (m - 1);
            ret++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}