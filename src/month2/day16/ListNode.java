package month2.day16;

public class ListNode {
    int val;
    ListNode next;

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
