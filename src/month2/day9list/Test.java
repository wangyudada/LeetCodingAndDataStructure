package month2.day9list;

public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode(listNode,5);
        ListNode listNode2 = new ListNode(listNode1, 4);
        ListNode listNode3 = new ListNode(listNode2, 3);
        ListNode listNode4 = new ListNode(listNode3, 2);
        ListNode listNode5 = new ListNode(listNode4, 1);
        ListNode listNode6 = demo.reverseList(listNode);
        System.out.println(listNode6);
    }
}
