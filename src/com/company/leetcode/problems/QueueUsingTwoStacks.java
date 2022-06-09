package com.company.leetcode.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public void runTwoStacks() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            int queryCount = new Integer(buff.readLine()).intValue();
            if (queryCount == 1) return;
            Queue q = Queue.class.newInstance();
            for (int i=0;i<queryCount;i++) {
                String line = buff.readLine();
                String[] s = line.split(" ");
                int command = new Integer(s[0]).intValue();
                Integer number = s.length == 2 ? new Integer(s[1]) : 0;
                switch (command) {
                    case 1 : {
                        q.enQueue(number);
                        break;
                    }
                    case 2 : {
                        q.deQueue();
                        break;
                    }
                    case 3 : {
                        q.peek();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }


    public class Queue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public Queue() {
            super();
        }

        public void enQueue(Integer num) {
            stack1.push(num);
        }

        public void deQueue() {
            if (stack2.isEmpty()) {
                swap(stack2,stack1);
            }
            if (!stack2.isEmpty()) stack2.pop();
        }
        public void peek() {
            if (stack2.isEmpty()) {
                swap(stack2,stack1);
            }
            System.out.println(stack2.peek());
        }

        private void swap(Stack<Integer> to,Stack<Integer> from) {
            while (from.isEmpty() == false) {
                to.push(from.pop());
            }
        }
    }
}
