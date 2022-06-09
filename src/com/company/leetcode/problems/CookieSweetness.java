package com.company.leetcode.problems;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CookieSweetness {

    public static int cookies(int k, List<Integer> a) {
        if (a.size() == 1) return 0;
        Queue<Long> q = new PriorityQueue<Long>();
        for (Integer x : a) {
            q.add(new Long(x.toString()));
        }
        int count = 0;
        while ((q.peek() < k) && (q.size() > 1)) {
            Long head = q.poll() + (2 * q.poll());
            q.add(head);
            count++;
        }
        if (q.peek() >= k) return count;
        return -1;
    }
}
