package month2.day27;

import java.util.ArrayList;

public class Solution {
    public static String toGoatLatin(String sentence) {
        StringBuilder voStr = new StringBuilder();
        ArrayList<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('A');
        chars.add('E');
        chars.add('e');
        chars.add('I');
        chars.add('i');
        chars.add('O');
        chars.add('o');
        chars.add('U');
        chars.add('u');
        if (sentence.length() <= 0) {
            return null;
        }
        if (!sentence.contains(" ")) {
            char c = sentence.charAt(0);
            if (chars.contains(c)) {
                sentence = sentence + "maa";
            } else {
                char c1 = sentence.charAt(0);
                sentence = sentence.substring(1, sentence.length()) + c1 + "maa";
            }
            return sentence;
        }
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (chars.contains(strs[i].charAt(0))) {
                String str2 = strs[i] + "ma";
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <= i; j++) {
                    sb.append("a");
                }
                str2 = str2 + sb.toString();
                if (i + 1 >= strs.length) {
                    voStr.append(str2);
                }else {
                    voStr.append(str2 + " ");
                }
            } else {
                char c1 = strs[i].charAt(0);
                String str2 = strs[i].substring(1, strs[i].length()) + c1 + "ma";
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <= i; j++) {
                    sb.append("a");
                }
                str2 = str2 + sb.toString();
                if (i + 1 >= strs.length) {
                    voStr.append(str2);
                }else {
                    voStr.append(str2 + " ");
                }
            }
        }
        return voStr.toString();
    }
}
