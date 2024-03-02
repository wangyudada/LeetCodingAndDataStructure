package month2.day16;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode listNode) {
        this.val = val;
        next = listNode;
    }
}
