package month3.day26;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        int i = myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        int j = myLinkedList.get(1);
        System.out.println();
    }
}
