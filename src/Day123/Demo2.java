package Day123;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Person("Wang", 23));
        hashSet.add(new Person("Xiao", 23));
        hashSet.add(new Person("Zhang", 23));
        hashSet.add(new Person("Hu", 23));
        hashSet.add(new Person("Sun", 23));
//        hashSet.add(new Person("Sun", 23));
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    static class Person {
        private String name;
        private int age;

        Person() {

        }

        public Person(String name, int age) {

            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            System.out.println("hashCode:" + this.name);
            return this.name.hashCode() + age * 37;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println(this + "---equals---" + obj);
            if (obj instanceof Person) {
                Person p = (Person) obj;
                return this.name.equals(p.name) && this.age == p.age;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {

            return "Person@name:" + this.name + " age:" + this.age;
        }
    }
}
