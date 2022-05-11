package month3.day2;

public class Demo {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String str = "2, 1, 3";
        TreeNode deserialize = codec.deserialize(str);
    }
}
