/*
[1007]行相等的最少多米诺旋转
minimum-domino-rotations-for-equal-row
//在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 
//该平铺的每一半上都有一个数字。） 
//
// 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。 
//
// 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。 
//
// 如果无法做到，返回 -1. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
//输出：2
//解释：
//图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
//如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
// 
//
// 示例 2： 
//
// 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
//输出：-1
//解释：
//在这种情况下，不可能旋转多米诺牌使一行的值相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A[i], B[i] <= 6 
// 2 <= A.length == B.length <= 20000 
// 
// Related Topics 贪心算法 数组

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1007MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        //Solution solution = new P1007MinimumDominoRotationsForEqualRow().new Solution();
    }

    /**
     * 思路：
     * 要使一行的数字全相等，那么必须每块多米诺的两个数字中存在一个与其他多米诺相等的数
     * 因此我们将每个多米诺的两个数字作为集合，将所有的集合进行交集
     * 若集合不为空，则可以实现
     * 同时，全相同的数字为第一块多米诺的其中一个数字，因此取交集的时候我们统计与该数字相等的相同位置的骨牌数量
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        boolean first = true;
        boolean second = true;

        int firstCount = 0;
        int firstCount2 = 0;
        int secondCount = 0;
        int secondCount2 = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[0] != A[i] && A[0] != B[i]) {
                first = false;
            }
            if (A[0] == A[i]) {
                firstCount++;
            }
            if (A[0] == B[i]) {
                firstCount2++;
            }

            if (B[0] != A[i] && B[0] != B[i]) {
                second = false;
            }
            if (B[0] == B[i]) {
                secondCount++;
            }
            if (B[0] == A[i]) {
                secondCount2++;
            }
            if (!first && !second) {
                return -1;
            }
        }
        int min = A.length;
        if (first) {
            min = Math.min(A.length - firstCount2, A.length - 1 - firstCount);
        }
        if (second) {
            min = Math.min(min, A.length - 1 - secondCount);
            min = Math.min(min, A.length - secondCount2);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}