package day28;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
 * 不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,1,2,2,2]
 * 输出: true
 * <p>
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例2:
 * <p>
 * 输入: [3,3,3,3,4]
 * 输出: false
 * <p>
 * 解释: 不能用所有火柴拼成一个正方形。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 *
 * @author WangYu
 */
public class Demo {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        //统计所有火柴的长度
        for (int num : matchsticks) {
            sum += num;
        }
        //如果所有火柴的长度不是4的倍数，直接返回false
        if (sum == 0 || (sum & 3) != 0) {
            return false;
        }
        return dfs(matchsticks, 0, sum >> 2, new int[4]);
    }

    private boolean dfs(int[] matchsticks, int idx, int target, int[] size) {
        if (idx == matchsticks.length) {
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3]) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < size.length; i++) {
            if (size[i] + matchsticks[idx] > target) {
                continue;
            }
            size[i] += matchsticks[idx];
            if (dfs(matchsticks, idx + 1, target, size)) {
                return true;
            }
            size[i] -= matchsticks[idx];
        }
        return false;
    }

}
