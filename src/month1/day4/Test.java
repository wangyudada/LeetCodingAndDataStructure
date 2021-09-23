package month1.day4;

public class Test {
    public static void main(String[] args) {
        Tree node = new Tree();
        node.insert(3, 3.666);
        node.insert(1, 1.111);
        node.insert(2, 2.362);
        node.insert(4, 4.672);
        node.insert(5, 5.865);
        node.insert(6, 6.681);
        Node node1 = node.find(5);
        if (node1 == null) {
            System.out.println("无");
        } else {
            node1.showNode();
        }
        Node[] nodes = node.mVal();
        nodes[0].showNode();
        nodes[1].showNode();
    }
}
