package month3.day9;

public class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/integer-to-roman/solutions/774611/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcod-75rs/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public String intToRoman(int num) {
    StringBuilder result = new StringBuilder();
    dfs(num,result);
    return result.toString();
}

    private String dfs(int num,StringBuilder result){
        if (num == 0){
            return result.toString();
        }
        for (int i = 0; i < values.length; i++) {
            while (num>=values[i]){
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        return dfs(num,result);
    }
}