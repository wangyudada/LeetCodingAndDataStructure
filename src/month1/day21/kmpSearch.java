package month1.day21;

/**
 * 字符串匹配算法
 *
 * @author 王宇
 */
public class kmpSearch {

    public static void main(String[] args) {
        int kmp = kmp("ABCDA", "DA");
        System.out.println(kmp);
    }

    /**
     * 计算部分匹配值
     *
     * @param p 传入的字符串
     * @return next 字符串的部分匹配值
     */
    private static int[] getNext(String p) {
        int[] next = new int[p.length()];
        next[0] = 0;
        /*
            j表示前缀起始位置，i表示后缀起始位置
         */
        int j = 0, i = 1;
        for (; i < p.length(); i++) {
            while (j > 0 && p.charAt(j) != p.charAt(i)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * 开始匹配
     *
     * @param str  被匹配的字符串 例如ABCDA
     * @param dest 匹配的字符串 例如DA
     * @return 下标
     */
    private static int kmp(String str, String dest) {
//        先求出部分匹配数组
        int[] next = getNext(dest);
        for (int i = 0, j = 0; i < str.length(); i++) {
//            如果已经开始匹配dest，且当前的dest字符和str字符不同
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
//            当匹配的两个字符相同，则匹配下一个dest字符
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
//            dest已经匹配结束，返回下标
            if (j == dest.length()) {
                return i - j + 1;
            }
//            如果尚未开始匹配dest，则直接跳过当前i，一直到i对应的str字符匹配dest的第一个字符
        }
        return -1;
    }

}
