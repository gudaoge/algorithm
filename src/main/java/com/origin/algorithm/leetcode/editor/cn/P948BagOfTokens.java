/*
[948]令牌放置
bag-of-tokens
//你的初始 能量 为 P，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。 
//
// 令牌可能的两种使用方法如下： 
//
// 
// 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。 
// 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。 
// 
//
// 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。 
//
// 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：tokens = [100], P = 50
//输出：0
//解释：无法使用唯一的令牌，因为能量和分数都太少了。 
//
// 示例 2： 
//
// 
//输入：tokens = [100,200], P = 150
//输出：1
//解释：令牌 0 正面朝上，能量变为 50，分数变为 1 。不必使用令牌 1 ，因为你无法使用它来提高分数。 
//
// 示例 3： 
//
// 
//输入：tokens = [100,200,300,400], P = 200
//输出：2
//解释：按下面顺序使用令牌可以得到 2 分：
//1. 令牌 0 正面朝上，能量变为 100 ，分数变为 1
//2. 令牌 3 正面朝下，能量变为 500 ，分数变为 0
//3. 令牌 1 正面朝上，能量变为 300 ，分数变为 1
//4. 令牌 2 正面朝上，能量变为 0 ，分数变为 2 
//
// 
//
// 提示： 
//
// 
// 0 <= tokens.length <= 1000 
// 0 <= tokens[i], P < 104 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P948BagOfTokens {
    public static void main(String[] args) {
        //Solution solution = new P948BagOfTokens().new Solution();
    }

    /**
     * 思路：
     * 尽可能用少能量的令牌用来得积分
     * 用大能量的令牌来获取能量
     * 因为顺序不限，因此按能量大小对令牌进行排序
     *
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        int score = 0;

        int left = 0;
        int right = tokens.length - 1;

        int maxScore = 0;

        while (left <= right) {
            if (P >= tokens[left]) {
                //能量足够 消耗能量得分
                score++;
                maxScore = Math.max(maxScore, score);
                P -= tokens[left];
                left++;
            } else {
                if (score <= 0) {
                    break;
                }
                //能量不够 消耗积分得能量
                score--;
                P += tokens[right];
                right--;
            }
        }

        return maxScore;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}