// 低端版
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int totank = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i];
            totank += gas[i];
            total += cost[i];
            if (tank >= cost[i]) {
                tank -= cost[i];
            }
            else {
                start = i+1;
                tank = 0;
            }
        }
        return total > totank? -1 : start;
    }
}
// 高级版：https://leetcode.com/discuss/4159/share-some-of-my-ideas
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            if ((tank = tank+gas[i]-cost[i]) < 0) {
                start = i+1;
                total += tank;
                tank = 0;
            }
        }
        // 如果你之前离下一站差-1到不了， total=-1,如果最终油箱里剩的汽油大于之前缺的（tank+total>0）
        // 那么就说明可以到
        return tank+total>=0 ? start:-1;
    }
}
