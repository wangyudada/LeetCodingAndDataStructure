package month2.day9list;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(ListNode next, int val) {
        this.val = val;
        this.next = next;
    }
}