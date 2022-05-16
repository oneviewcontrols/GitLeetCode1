package com.company.leetcode.problems;

import com.company.leetcode.util.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else  {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }





















    public ListNode mergeTwoListsOld(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }



    static ListNode buildTestNode1() {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(4);
        return head;
    }

    static ListNode buildTestNode2() {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        return head;
    }
    public static void runTest() {
        ListNode one =  buildTestNode1();
        ListNode two = buildTestNode2();
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode result = m.mergeTwoLists(one,two);
        System.out.print("[");
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println("]");
    }

}
