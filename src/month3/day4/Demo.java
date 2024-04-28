package month3.day4;

import month2.day16.ListNode;

public class Demo {
    public static void main(String[] args) {

        ListNode listNode = new ListNode();
//        ListNode listNode1 = new ListNode(2, listNode);
//        ListNode listNode2 = new ListNode(2, listNode1);
//        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(1, listNode);
        ListNode listNode5 = new ListNode(1, listNode4);
        ListNode listNode1 = new Solution().deleteDuplicates(listNode5);
        System.out.println();

        int abcabcbb = new Solution().lengthOfLongestSubstring("aab");
    }
}
