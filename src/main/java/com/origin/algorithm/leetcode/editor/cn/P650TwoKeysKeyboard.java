/*
[650]只有两个键的键盘
2-keys-keyboard
//最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。 
// Paste (粘贴) : 你可以粘贴你上一次复制的字符。 
// 
//
// 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。 
//
// 示例 1: 
//
// 
//输入: 3
//输出: 3
//解释:
//最初, 我们只有一个字符 'A'。
//第 1 步, 我们使用 Copy All 操作。
//第 2 步, 我们使用 Paste 操作来获得 'AA'。
//第 3 步, 我们使用 Paste 操作来获得 'AAA'。
// 
//
// 说明: 
//
// 
// n 的取值范围是 [1, 1000] 。 
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P650TwoKeysKeyboard {
    public static void main(String[] args) {
        //Solution solution = new P650TwoKeysKeyboard().new Solution();
    }

    /**
     * 思路：
     * n个A可以由n-1个A粘贴1个A得到
     * n个A可以由n-2个A粘贴2个A得到
     * n个A可以由n-x个A粘贴x个A得到
     *
     *
     * 假设要得到n个A需要的次数为f(n),复制的A长度为x
     * 可见f(n)与f(n-x)以及上一次复制的A有关
     *
     * 1.每次粘贴可以沿用上次复制的x (x < n-1):
     * 则f(n,x)=f(n-x,x) + 1
     * 2.或者重新复制 (x=n-1)
     * 重新复制时 只做复制，没有粘贴
     * 则f(n, x)= min(f(n)) + 1
     *
     * TODO 其他解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(int n) {
        //n=1是特殊情况
        if (n == 1) {
            return 0;
        }
        //n>1时

        int[][] dp = new int[n + 1][n + 1];
        //初始化n=1的值
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //沿用上次复制进行粘贴的情况 即 x< n-1
            for (int j = 1; j < i; j++) {
                if (i - j >= j && dp[i - j][j] > -1) {
                    dp[i][j] = dp[i - j][j] + 1;
                    min = Math.min(dp[i][j], min);
                } else {
                    //-1表示无法实现
                    dp[i][j] = -1;
                }
            }
            //重新复制 不做粘贴
            dp[i][i] = min + 1;
        }
        //寻找出最小的操作数
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            if (dp[n][i] > 0) {
                min = Math.min(dp[n][i], min);
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}