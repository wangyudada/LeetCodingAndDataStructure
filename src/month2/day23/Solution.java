package month2.day23;


import java.util.*;

public class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.length() < 0) {
            return null;
        }
        String vo = null;
        paragraph = paragraph.toLowerCase();
        HashSet<String> ban = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        int lastIdx = 0;
        boolean have = false;
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) > 122 || paragraph.charAt(i) < 97) {
                if ((i - 1) >= 0 && (paragraph.charAt(i - 1) <= 122 && paragraph.charAt(i - 1) >= 97)) {
                    String str = "";
                    if (lastIdx == 0) {
                        str = paragraph.substring(lastIdx, i);
                    } else {
                        str = paragraph.substring(lastIdx + 1, i);
                    }
                    if (!map.containsKey(str)) {
                        map.put(str, 1);
                    } else {
                        map.put(str, map.get(str) + 1);
                    }
                }
                lastIdx = i;
                have = true;
            } else if (i == paragraph.length() - 1) {
                String str = "";
                if (lastIdx == 0) {
                    str = paragraph.substring(lastIdx, i);
                } else {
                    str = paragraph.substring(lastIdx + 1, i + 1);
                }
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    map.put(str, map.get(str) + 1);
                }
            }
        }
        if (!have) {
            return paragraph;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            if (!ban.contains(entry.getKey())) {
                vo = entry.getKey();
                break;
            }
        }
        return vo;
    }
}
