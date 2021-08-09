package Day123;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Demo6 {
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangwu");

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            map.remove("1");
        }
    }
}
