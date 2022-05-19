package com.company.leetcode.assessments.roundone;

import com.company.leetcode.util.Node;
import com.company.leetcode.util.NodeCopy;

import java.util.HashMap;
import java.util.Map;

public class BloombergTwo {

    Map<Node,NodeCopy> map = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        NodeCopy copy = copyNode(root,map);
        copyRandoms(root,copy,map);
        return copy;
    }

    private NodeCopy copyNode(Node node,Map<Node,NodeCopy> map) {
       if (node == null) return null;
        NodeCopy copy = new NodeCopy(node.val);
        map.put(node,copy);
        copy.right = copyNode(node.right,map);
        copy.left = copyNode(node.left,map);
        return copy;
    }

    private void copyRandoms(Node node,NodeCopy copy,Map<Node,NodeCopy> map) {
        if (copy == null) return;
        copy.random = map.get(node.random);
        copyRandoms(node.left,copy.left,map);
        copyRandoms(node.right,copy.right,map);
    }
}

