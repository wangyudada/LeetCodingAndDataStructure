package Day123;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Demo5 {

    private static Map<String, Consumer<String>> FUNC_MAP = new ConcurrentHashMap<>();
    private static String MAN = "man";
    private static String WOMAN = "woman";

    static {
        FUNC_MAP.put(MAN, person -> {
            System.out.println(person + "应该去男厕所");
        });
        FUNC_MAP.put(WOMAN, person -> {
            System.out.println(person + "应该去女厕所");
        });
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setGender(MAN);
        p.setName("张三");
        Person p2 = new Person();
        p2.setGender(WOMAN);
        p2.setName("张三他老婆");

        FUNC_MAP.get(p.getGender()).accept(p.name);
        FUNC_MAP.get(p2.getGender()).accept(p2.name);
    }

    static class Person {
        private String gender;
        private String name;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
