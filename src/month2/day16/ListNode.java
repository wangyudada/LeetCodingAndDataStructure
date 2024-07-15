package month2.day16;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode listNode) {
        this.val = val;
        next = listNode;
    }
}
