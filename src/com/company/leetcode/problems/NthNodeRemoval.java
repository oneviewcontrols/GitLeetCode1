package com.company.leetcode.problems;
import com.company.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class NthNodeRemoval {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();
        map.put(0,head);
        ListNode node = head;
        int i = 1;
        while (node.next != null) {
            map.put(i,node.next);
            node = node.next;
            i++;
        }
        if (n > (map.size() - 1)) return null;
        ListNode nodeAtN = map.get(n);
        ListNode nodeToRemove = nodeAtN.next != null ? nodeAtN.next : null;
        if (nodeToRemove == null) return null;
        if (nodeToRemove.next == null) return null;
        ListNode newNext = nodeToRemove.next;
        nodeAtN.next = newNext;
        head = map.get(0);
        return head;
    }

    public ListNode buildTestCase(int nodes) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i=1; i<nodes;i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = next;
        }
        return head;
    }

    public static void runTestCase() {
        NthNodeRemoval n = new NthNodeRemoval();
        ListNode node = n.buildTestCase(2);
        node = n.removeNthFromEnd(node,1);
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println("]");
    }
}
