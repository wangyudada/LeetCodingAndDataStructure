package Day123;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Demo3 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add(new Book("wuhu", 233));
        ts.add(new Book("wahaha", 233));
        ts.add(new Book("yihaha", 233));
        ts.add(new Book("hhhh", 233));
        System.out.println(ts);
    }

    static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
            System.out.println(b1 + "compareTo" + b2);
            if (b1.getPrice() == b2.getPrice()) {
                return b1.getName().compareTo(b2.getName());
            } else {
                return b1.getPrice() > b2.getPrice() ? 1 : -1;
            }
        }
    }

    static class Book {
        private String name;
        private double price;

        public Book() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Book(String name, double price) {

            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book [name=" + name + ", price=" + price + "]";
        }

    }

}
