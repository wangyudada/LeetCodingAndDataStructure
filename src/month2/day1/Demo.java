package month2.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * @author WangYu
 */
public class Demo {
    public List<String> generateParenthesis(int n) {
        List<String>[] res = new List[n + 1];
        ArrayList<String> list0 = new ArrayList<>();
        list0.add("");
        res[0] = list0;
        for (int i = 1; i <= n; i++) {
            ArrayList<String> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int k = i - 1 - j;
                List<String> re = res[j];
                List<String> re1 = res[k];
                for (String s : re) {
                    for (String s1 : re1) {
                        curr.add("(" + s + ")" + s1);
                    }
                }
            }
            res[i] = curr;
        }
        return res[n];
    }
}
