package club.cser.leetcode;

import java.util.ArrayList;
import java.util.List;
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
class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> path = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode iter = root;

        while (null != iter || !path.empty()) {

            if (null != iter) {
                path.push(iter);
                iter = iter.left;
            } else {
                res.add(path.peek().val);
                iter = path.peek().right;
                path.pop();
            }

        }
        return res;
    }

    public List<Integer> inorderMorrisTraversal(TreeNode root) {


        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while (null != cur) {
            if (null != cur.left) {
                TreeNode rightMostNodeOfLeftSubtree = cur.left;

                while (rightMostNodeOfLeftSubtree.right != null && rightMostNodeOfLeftSubtree.right != cur)
                    rightMostNodeOfLeftSubtree = rightMostNodeOfLeftSubtree.right;

                if (rightMostNodeOfLeftSubtree.right == null) {
                    rightMostNodeOfLeftSubtree.right = cur;
                    cur = cur.left;
                } else {
                    rightMostNodeOfLeftSubtree.right = null;

                    res.add(cur.val);
                    cur = cur.right;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

}