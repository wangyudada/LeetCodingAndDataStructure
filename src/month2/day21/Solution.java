package month2.day21;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }
}
