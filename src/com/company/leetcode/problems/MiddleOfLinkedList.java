package com.company.leetcode.problems;

import com.company.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        map.put(0,head);
        head = head.next;
        int i = 0;
        while (head != null) {
            i++;
            map.put(i,head);
            head = head.next;
        }
        return map.get(map.size() / 2);
    }
}
