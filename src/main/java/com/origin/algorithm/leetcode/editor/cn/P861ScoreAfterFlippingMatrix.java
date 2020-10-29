/*
[861]翻转矩阵后的得分
score-after-flipping-matrix
//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P861ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        //Solution solution = new P861ScoreAfterFlippingMatrix().new Solution();
    }

    /**
     * 思路：
     * 尽可能的将矩阵前方的数字变为1
     * 目前来看，先将每一行的第一位都变成1
     * 然后将每一列翻转使每列的1变多
     * 就能使结果最大了
     *
     * 然而该怎么证明呢？
     * TODO 证明
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matrixScore(int[][] A) {
        //翻转行 使第一位变成1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = A[i][j] ^ 1;
            }
        }
        //翻转列，使列中1最多
        for (int i = 0; i < A[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum+= A[j][i];
            }
            if (sum < A.length - sum) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = A[j][i] ^ 1;
                }
            }
        }
        //计算结果
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int cur = 0;
            for (int j = 0; j < A[0].length; j++) {
                cur = cur * 2 + A[i][j];
            }
            sum += cur;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}