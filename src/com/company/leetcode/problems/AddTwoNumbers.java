package com.company.leetcode.problems;

import com.company.leetcode.util.ListNode;

// Different Change
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while ((l1 != null) || (l2 != null)) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int total  = val1 + val2 + carry;
            carry = total / 10;
            int val = total % 10;
            current.next = new ListNode(val);
            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
