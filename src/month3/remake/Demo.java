package month3.remake;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(0);
        int i = list.get(0);
        list.deleteAtIndex(0);
        int j = list.get(0);
        System.out.println();
    }
}
