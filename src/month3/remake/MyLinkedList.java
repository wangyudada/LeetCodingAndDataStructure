package month3.remake;

import month2.day16.ListNode;

public class MyLinkedList {
    int size;

    ListNode node;

    public MyLinkedList() {
        this.size = 0;
        this.node = new ListNode();
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode dummyNode = node;
        while (index != 0) {
            index--;
            dummyNode = dummyNode.next;
        }
        return dummyNode.next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }
        size++;
        ListNode newNode = new ListNode(val);
        ListNode dummyNode = node;
        while (index != 0) {
            index--;
            dummyNode = dummyNode.next;
        }
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            index = 0;
        }
        if (index >= size) {
            return;
        }
        size--;
        ListNode dummyNode = node;
        while (index != 0) {
            index--;
            dummyNode = dummyNode.next;
        }
        dummyNode.next =dummyNode.next.next;
    }
}
