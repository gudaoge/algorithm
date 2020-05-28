/*
[857]雇佣 K 名工人的最低成本
minimum-cost-to-hire-k-workers
//有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。 
//
// 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资： 
//
// 
// 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。 
// 工资组中的每名工人至少应当得到他们的最低期望工资。 
// 
//
// 返回组成一个满足上述条件的工资组至少需要多少钱。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入： quality = [10,20,5], wage = [70,50,30], K = 2
//输出： 105.00000
//解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。 
//
// 示例 2： 
//
// 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
//输出： 30.66667
//解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
//
// 
//
// 提示： 
//
// 
// 1 <= K <= N <= 10000，其中 N = quality.length = wage.length 
// 1 <= quality[i] <= 10000 
// 1 <= wage[i] <= 10000 
// 与正确答案误差在 10^-5 之内的答案将被视为正确的。 
// 
// Related Topics 堆

*/


package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P857MinimumCostToHireKWorkers{
    public static void main(String[] args) {
        // Solution solution = new P857MinimumCostToHireKWorkers().new Solution();
        // TO TEST
    }

    /**
     * 假设有k名工人
     * 则总的工作质量为qualitySum
     * 总工资为wageSum
     * 则有quality[i]/qualitySum * wageSum >= wage[i]
     * 经过转换得到
     * wageSum >= wage[i] * qualitySum / quality[i]
     * 因此选定的k个数后，wageSum的最小值为max(wage[i] * qualitySum / quality[i])
     *
     * 假设提前计算好wage/quality的值的数组 rate
     *
     * 问题就转换为 max(rate[i]) * sum(quality[i])的最小值
     * 将问题转化为 选定一个i，找到使sum最小的，rate小于等于rate[i]的k个数
     * 那么需要n-k次遍历选定i，
     * 每次选定i之后，选取小于等于rate[i]的所有数
     * 从这些数选择最小的k-1个数
     * O((n-k)*n*log(k))
     * 将rate升序排序，那么每次选定i时只需要将i右移一次即可，小于等于rate[i]的数增加一个
     * 从0到i-1中选取最小的k-1个数，采用大根堆
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public class Worker {
        double rate;
        int quality;

        public Worker(double rate, int quality) {
            this.rate = rate;
            this.quality = quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] worker = new Worker[quality.length];

        for (int i = 0; i < quality.length; i++) {
            worker[i] = new Worker((double) wage[i]/quality[i], quality[i]);
        }
        Arrays.sort(worker, Comparator.comparingDouble(o -> o.rate));

        //存放小于rate[i]的qulity最小的k-1个
        PriorityQueue<Worker> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.quality, o1.quality));

        //前k-1个最小的quality的和
        int qualitySum = 0;

        //当前得到的最小的总支出
        double minWage = Double.MAX_VALUE;

        for (int i = 0; i < worker.length; i++) {
            if (heap.size() == K - 1) {
                minWage = Math.min(minWage, (qualitySum + worker[i].quality) * worker[i].rate);
            }
            //当前的处理完毕了，即将处理下一个员工，因此要把当前的员工放入堆中
            heap.offer(worker[i]);
            qualitySum += worker[i].quality;
            while (heap.size() > K - 1) {
                qualitySum -= heap.poll().quality;
            }
        }
        return minWage;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}