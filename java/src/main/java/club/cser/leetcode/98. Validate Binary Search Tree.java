package club.cser.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

class ValidateBinarySearchTree {
/*    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> path = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode iter = root;
        Optional<Integer> pre = Optional.empty();
        int cur;

        while (null != iter || !path.empty()) {

            if (null != iter) {
                path.push(iter);
                iter = iter.left;
            } else {
                cur = path.peek().val;
                if (pre.isPresent() && cur <= pre.get())
                    return false;
                else
                    pre = Optional.of(cur);
                iter = path.peek().right;
                path.pop();
            }

        }
        return true;
    }*/

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> path = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode iter = root;
        Integer pre = null;
        int cur;

        while (null != iter || !path.empty()) {

            if (null != iter) {
                path.push(iter);
                iter = iter.left;
            } else {
                cur = path.peek().val;
                if (null != pre && cur <= pre)
                    return false;
                else
                    pre = cur;
                iter = path.peek().right;
                path.pop();
            }

        }
        return true;
    }
}