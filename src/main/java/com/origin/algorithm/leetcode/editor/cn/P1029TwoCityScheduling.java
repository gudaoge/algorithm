/*
[1029]两地调度
two-city-scheduling
//公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。 
//
// 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。 
//
// 
//
// 示例： 
//
// 输入：[[10,20],[30,200],[400,50],[30,20]]
//输出：110
//解释：
//第一个人去 A 市，费用为 10。
//第二个人去 A 市，费用为 30。
//第三个人去 B 市，费用为 50。
//第四个人去 B 市，费用为 20。
//
//最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= costs.length <= 100 
// costs.length 为偶数 
// 1 <= costs[i][0], costs[i][1] <= 1000 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P1029TwoCityScheduling {
    public static void main(String[] args) {
        //Solution solution = new P1029TwoCityScheduling().new Solution();
    }

    /**
     * 思路：
     * 若前一半去B城市，后一半去A城市，总费用为
     * A[i] + A[i+1] + ... A[n-1] + B[0] + B[1] + ...B[i-1]
     * A[i] + A[i+1] + ... A[n-1] + A[0] + B[0] - A[0] + ... A[i-1] + B[i-1] - A[i-1]
     * = sum(A) + sum(B[i]-A[i])
     * sum(A)为定值，则只需求最小的B[i]-A[i]
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[] costDiff = new int[costs.length];

        int sumA = 0;
        for (int i = 0; i < costs.length; i++) {
            sumA += costs[i][0];
            costDiff[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(costDiff);

        for (int i = 0; i < costDiff.length/2; i++) {
            sumA += costDiff[i];
        }
        return sumA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}