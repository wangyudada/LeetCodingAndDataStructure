package month3.day3;

import month2.day16.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * https://leetcode.cn/problems/rotate-list/description/
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int size = 1;
        ListNode pre = head;
        while (pre.next != null) {
            size++;
            pre = pre.next;
        }
        int index = size - (k % size);
        if (index == size) {
            return head;
        }
        pre.next = head;
        while (index-- > 0) {
            pre = pre.next;
        }
        ListNode result = pre.next;
        pre.next = null;
        return result;
    }
}