package club.cser.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UniqueBinarySearchTreesII {
    // 递归
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

    // dp
    public List<TreeNode> generateTreesDP(int n) {
        if (n == 0)
            return new ArrayList<>();
        List<TreeNode>[] subtrees = new ArrayList[n + 1];


        subtrees[0] = new ArrayList<>();
        subtrees[0].add(null);

        for (int i = 1; i <= n; i++) {
            subtrees[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left: subtrees[j - 1]) {
                    for (TreeNode right: subtrees[i - j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = copyTreeWithOffset(right, j);
                        subtrees[i].add(root);
                    }
                }
            }
        }
        return subtrees[n];
    }

    private TreeNode copyTreeWithOffset(TreeNode root, int offset) {
        if (root == null)
            return null;
        TreeNode res = new TreeNode(root.val + offset);
        res.left = copyTreeWithOffset(root.left, offset);
        res.right = copyTreeWithOffset(root.right, offset);
        return res;
    }
}