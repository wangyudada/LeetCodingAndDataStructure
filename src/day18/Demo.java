package day18;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，
 * 找出candidates中所有可以使数字和为目标数target的唯一组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * <p>
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个
 * <p>
 * 示例1：
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * @author WangYu
 */
public class Demo {
    public static void main(String[] args) {
        int[] ints = {2, 3, 6, 7};
        combinationSum(ints, 6);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> combine = new ArrayList<>();
        dfs(candidates, target, res, combine, 0);
        return res;
    }

    /**
     * 递归函数
     *
     * @param candidates 当前数组
     * @param target     累加结果数
     * @param res        累计结果链表
     * @param combine    已经组合的数组，下标idx每右移一位就插入一个candidate在之前这位的元素
     * @param idx        在candidates的下标
     */
    public static void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int idx) {
//        如果candidates数组全部用完
        if (idx == candidates.length) {
            return;
        }
//        如果累加的数为0(这边指的是第57行中target-candidates[idx]为0)
        if (target == 0) {
//            将已经组合的数组返回
            res.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates, target, res, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], res, combine, idx);
//            清除已经组合的数组
            combine.remove(combine.size() - 1);
        }
    }
}
