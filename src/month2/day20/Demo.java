package month2.day20;

public class Demo {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.insert(1);
        rs.insert(3);
        rs.insert(2);
        rs.insert(5);
        rs.insert(6);
        rs.remove(2);
        System.out.println(rs.getRandom());
    }
}
