package com.company.leetcode.problems;

import com.company.leetcode.util.Node;

public class HuffmanDecodingTree {


    void decode(String s, Node root) {
        StringBuilder builder = new StringBuilder();

        while (s.length() > 0) {
            char command = s.toCharArray()[0];
            s = s.substring(1);
            if (command == '0') {
                s = search(s,root.left,builder);
            } else {
                s = search(s,root.right,builder);
            }
        }
        System.out.println(builder.toString());
    }

    public String search(String s,Node node,StringBuilder builder) {
        if (node == null) return s;
        if ((node.left == null) && (node.right == null)) {
            builder.append(node.val);
            return s;
        }
        char command = s.toCharArray()[0];
        s = s.substring(1);
        if (command == '0')
            return search(s,node.left,builder);
        else
            return search(s,node.right,builder);
    }
}
