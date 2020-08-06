package club.cser.leetcode;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> path = new LinkedList<>();

        if (root != null) {
            path.offer(root);
            res.add(Arrays.asList(root.val));
        }
        int nodesOfCurRow = 1;

        while (!path.isEmpty()) {
            int nodesOfNextRow = 0;
            List<Integer> levelVal = new ArrayList<>();
            while (nodesOfCurRow -- > 0) {
                List<Node> children = path.poll().children;
                path.addAll(children);
                nodesOfNextRow += children.size();
                levelVal.addAll(children.stream().map(n -> n.val).collect(Collectors.toList()));
            }
            if (!levelVal.isEmpty())
                res.add(levelVal);
            nodesOfCurRow = nodesOfNextRow;
        }
        return res;
    }
}