package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    // Hash table that takes care of the map.
    private HashMap<Character, Character> map;
    {
        map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.empty()) return false;
                Character open = stack.pop();
                if (open.charValue() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.empty();
    }


    public boolean isValidold(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.map.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.map.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }



    public static void runTestCase() {
        ValidParentheses v = new ValidParentheses();
        // [{()}][]][
        String s1 = "[][()([]){}]";
        String s2 = "(";
        String s3 = "()]{}";
        String s4 = "()[]{";
        String s5 = ")[]{";
        System.out.println("[][()([]){}] = " + v.isValid(s1));
        System.out.println("( = " + v.isValid(s2));
        System.out.println("()]{} = " + v.isValid(s3));
        System.out.println("()[]{ = " + v.isValid(s4));
        System.out.println(")[]{} = " + v.isValid(s5));
    }
}

