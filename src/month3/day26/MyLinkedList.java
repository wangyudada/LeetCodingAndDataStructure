package month3.day26;

/**
 * https://leetcode.cn/problems/design-linked-list/submissions/542013381/
 */
public class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

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
        ListNode cur = node.next;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode cur = node;
        ListNode newNode = new ListNode(val);
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size--;
        ListNode cur = node;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
    }
}
