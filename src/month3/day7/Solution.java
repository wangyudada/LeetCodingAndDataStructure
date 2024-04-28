package month3.day7;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class Solution {
    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * 函数 myAtoi(string s) 的算法如下：
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     * 注意：
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     * 示例 3：
     * <p>
     * 输入：s = "4193 with words"
     * 输出：4193
     * 解释：
     * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     * ^
     * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * ^
     * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     * ^
     * 解析得到整数 4193 。
     * 由于 "4193" 在范围 [-2^31, 2^31 - 1] 内，最终结果为 4193 。
     * https://leetcode.cn/problems/string-to-integer-atoi/description/
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int result = 0;
        int max = Integer.MAX_VALUE / 10;
        int len = s.length();
        if (len == 0)
            return 0;
        int index = 0;
        while (s.charAt(index) == ' ')
            if (++index == len) return 0;
        int sign = 1;
        if (s.charAt(index) == '-') sign = -1;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }
        for (int j = index; j < len; j++) {
            if (s.charAt(j) < '0' || s.charAt(j) > '9') break;
            if (result > max || result == max && s.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(j) - '0');
        }
        return result * sign;
    }




}