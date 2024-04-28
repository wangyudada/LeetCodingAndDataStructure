package month3.day10;

public class Solution {
    /**
     * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
     * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
     * 示例 1：
     * 输入：n = 2
     * 输出："110"
     * 解释：(-2)2 + (-2)1 = 2
     * https://leetcode.cn/problems/convert-to-base-2/description/?envType=daily-question&envId=2024-04-28
     *
     * @param n
     * @return
     */
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            if (n % -2 == 0) {
                result.append("0");
            } else {
                n -= 1;
                result.append("1");
            }
            n /= -2;
        }
        return result.reverse().toString();
    }
}
