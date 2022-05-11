package month2.day26;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int lengthLongestPath(String input) {
        int ans = 0;
        int pos = 0;
        int n = input.length();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (pos < n) {
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                depth++;
                pos++;
            }
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            pos++;
            while (stack.size() >= depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }

            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }
}
