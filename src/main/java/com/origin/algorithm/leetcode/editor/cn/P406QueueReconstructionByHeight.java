/*
[406]根据身高重建队列
queue-reconstruction-by-height
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P406QueueReconstructionByHeight {
    public static void main(String[] args) {
        //Solution solution = new P406QueueReconstructionByHeight().new Solution();
    }

    /**
     * 思路：
     * 分析数据可知，身高相同的人肯定是按k升序排序的
     * 若队列为[h, k+1], [h,k],则第二人大于等于h的数量为k+2，与k冲突
     *
     * 对于不同身高的人，若先排更高的人，那么后续排低身高的人就不会影响到之前的人的相对顺序
     *
     * 因此我们可以模拟构建队列的过程
     * 先排高身高的人，同身高先排k较小的人
     * 所以首先需要排序，按h降序，相同h按k升序
     * 再循环遍历
     * 时间复杂度O(N^2)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        List<int[]> list = new LinkedList<>();

        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        return list.toArray(new int[people.length][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}