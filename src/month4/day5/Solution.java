package month4.day5;

import month2.day16.ListNode;

import java.util.ArrayList;

public class Solution {
    /**
     * https://leetcode.cn/problems/reorder-list/
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode pre = new ListNode(-1, head);
        while (pre.next != null) {
            nodeList.add(pre.next);
            pre = pre.next;
        }
        int i = 0, j = nodeList.size() - 1;
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        nodeList.get(i).next = null;
        System.out.println();
    }
}