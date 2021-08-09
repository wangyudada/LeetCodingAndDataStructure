package Day123;

import java.util.*;

public class Demo7 {
    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("Xiao", "Yu");
//        hashMap.put("A", "Yu");
//        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(hashMap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                return o1.getKey().compareTo(o2.getKey());
//            }
//        });
//        Iterator<Map.Entry<String, String>> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next.getKey() + ":" + next.getValue());
//        }
//        TreeMap<String, String> treeMap = new TreeMap<>();
//        treeMap.put("a", null);
//        treeMap.put("c", "1");
//        treeMap.put("b", "1");
//        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next.getKey() + ":" + next.getValue());
//        }
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "a");
        treeMap.put("b", "c");
        treeMap.put("c", "b");
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Iterator<Map.Entry<String, String>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
}
