package club.cser.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreorderTraversal {

    // Morris
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while (null != cur) {
            if (null != cur.left) {
                TreeNode rightMostNodeOfLeftSubtree = cur.left;

                while (rightMostNodeOfLeftSubtree.right != null && rightMostNodeOfLeftSubtree.right != cur)
                    rightMostNodeOfLeftSubtree = rightMostNodeOfLeftSubtree.right;

                if (rightMostNodeOfLeftSubtree.right == null) {
                    res.add(cur.val);
                    rightMostNodeOfLeftSubtree.right = cur;
                    cur = cur.left;
                } else {
                    rightMostNodeOfLeftSubtree.right = null;
                    cur = cur.right;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    // iterate
    public List<Integer> preorderTraversalIteration(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode top = s.pop();

            if (null != top) {
                res.add(top.val);
                s.push(top.right);
                s.push(top.left);
            }
        }
        return res;

    }
}