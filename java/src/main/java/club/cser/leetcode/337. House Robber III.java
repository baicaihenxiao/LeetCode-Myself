package club.cser.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class HouseRobberIII {
    public int rob(TreeNode root) {

        Map<TreeNode, Integer> selfInclusive = new HashMap<>();
        Map<TreeNode, Integer> selfExclusive = new HashMap<>();
        selfInclusive.put(null, 0);
        selfExclusive.put(null, 0);

        // 后序遍历
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur == null)
                continue;
            if (!s.isEmpty() && cur == s.peek()) {
                s.push(cur.right);
                s.push(cur.right);
                s.push(cur.left);
                s.push(cur.left);
            } else {
                selfInclusive.put(cur, cur.val + selfExclusive.get(cur.left) + selfExclusive.get(cur.right));
                selfExclusive.put(cur, Math.max(selfInclusive.get(cur.left), selfExclusive.get(cur.left)) + Math.max(selfInclusive.get(cur.right), selfExclusive.get(cur.right)));
            }
        }

        return Math.max(selfInclusive.get(root), selfExclusive.get(root));

    }
}