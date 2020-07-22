package club.cser.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; ++ i) {
            List<TreeNode> leftTrees = generate(left, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, right);

            for (TreeNode leftTree: leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }

        }
        return res;
    }
}