/*
[638]大礼包
shopping-offers
//在LeetCode商店中， 有许多在售的物品。 
//
// 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。 
//
// 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。 
//
// 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。 
//
// 任意大礼包可无限次购买。 
//
// 示例 1: 
//
// 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
//输出: 14
//解释: 
//有A和B两种物品，价格分别为¥2和¥5。
//大礼包1，你可以以¥5的价格购买3A和0B。
//大礼包2， 你可以以¥10的价格购买1A和2B。
//你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。 
//
// 示例 2: 
//
// 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
//输出: 11
//解释: 
//A，B，C的价格分别为¥2，¥3，¥4.
//你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
//你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
//你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
// 
//
// 说明: 
//
// 
// 最多6种物品， 100种大礼包。 
// 每种物品，你最多只需要购买6个。 
// 你不可以购买超出待购清单的物品，即使更便宜。 
// 
// Related Topics 深度优先搜索 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P638ShoppingOffers {
    public static void main(String[] args) {
        //Solution solution = new P638ShoppingOffers().new Solution();
    }

    /**
     * 思路：
     * 该题可以视为背包问题
     * 给定背包容量（代购清单）
     * 使用给定物品装满背包 (大礼包+单买) 物品本身不限量 单买可以视为只包含一个物品的大礼包
     * 使得总花费最小
     * 假设总花费为f(a,b,c,d，e,f) (a,b,c,d,e为清单中每个物品的数量)
     * 则f(a,b,c,d，e,f) = min(f(a-A,b-B,c-C,d-D,e-E,f-F) + A+B+C+D+E+F)
     *
     * TODO 回溯剪枝解法
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<List<Integer>, Integer> costMap = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, new ArrayList<>(needs));
    }

    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        boolean isEmpty = true;
        for (Integer need : needs) {
            if (need > 0) {
                isEmpty = false;
            }
        }
        if (isEmpty) {
            return 0;
        }
        if (costMap.containsKey(needs)) {
            return costMap.get(needs);
        }
        int cost = Integer.MAX_VALUE;
        //尝试单买1件
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) > 0) {
                List<Integer> remain = new ArrayList<>(needs);
                remain.set(i, needs.get(i) - 1);

                cost = Math.min(cost, shopping(price, special, remain) + price.get(i));
            }
        }
        //尝试购买大礼包
        for (List<Integer> pack : special) {
            if (hasRemain(pack, needs)) {
                List<Integer> remain = countRemain(pack, needs);
                cost = Math.min(cost, shopping(price, special, remain) + pack.get(pack.size() - 1));
            }
        }
        costMap.put(needs, cost);
        return cost;
    }

    private boolean hasRemain(List<Integer> pack, List<Integer> remain) {
        for (int i = 0; i < remain.size(); i++) {
            if (pack.get(i) > remain.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> countRemain(List<Integer> pack, List<Integer> remain) {
        List<Integer> needs = new ArrayList<>();
        for (int i = 0; i < remain.size(); i++) {
            needs.add(remain.get(i) - pack.get(i));
        }
        return needs;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}