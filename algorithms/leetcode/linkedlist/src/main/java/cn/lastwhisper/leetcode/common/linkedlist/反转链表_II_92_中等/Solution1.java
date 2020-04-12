package cn.lastwhisper.leetcode.common.linkedlist.反转链表_II_92_中等;

import cn.lastwhisper.leetcode.common.linkedlist.ListNode;

import static cn.lastwhisper.leetcode.common.linkedlist.LinkedListUtil.createListNode;
import static cn.lastwhisper.leetcode.common.linkedlist.LinkedListUtil.printListNode;

class Solution1 {
    /**
     * 题目地址：https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * -------------------------------------------------------------------
     * 思考：
     *  m大于n怎么办？
     *  m、n为负数怎么办？
     *  m、n超过链表长度怎么办？
     * -------------------------------------------------------------------
     * 思路：
     * -------------------------------------------------------------------
     * 时间复杂度：
     * 空间复杂度：
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        ListNode vNode = new ListNode(-1);
        vNode.next = head;

        // 保存反转前的前一个节点
        ListNode startNode = vNode;
        for (int i = 0; i < m - 1; i++) {
            startNode = startNode.next;
        }
        // 保存反转前的头节点
        ListNode mHead = startNode.next;

        // 反转需要的中间节点
        ListNode prev = null;
        ListNode current = mHead;
        ListNode next;

        for (int i = m; i < n+1; i++) {
            // 保存next
            next = current.next;
            // 反转
            current.next = prev;
            // prev、current后移
            prev = current;
            current = next;
        }

        // 反转前的前一个节点指向，反转后的头节点
        startNode.next = prev;
        // 反转前的头节点指向，反转后的endNode
        mHead.next = current;

        return vNode.next;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5};
        //int m = 2, n = 4;
        int[] arr = {3, 5};
        int m = 1, n = 2;

        printListNode(new Solution1().reverseBetween(createListNode(arr), m, n));
    }
}