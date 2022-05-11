package month2.day28;

public class Solution {
    public static int binaryGap(int n) {
        int last = -1;
        int vo = 0;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    vo = Math.max(vo, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return vo;
    }
}
