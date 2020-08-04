package club.cser.leetcode;

import java.util.*;

class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        int numOfCurRow = 0;


        if (root != null) {
            res.add(Arrays.asList(root.val));
            dq.addLast(root);
            numOfCurRow = 1;
        }

        while (!dq.isEmpty()) {
            List<Integer> nextRow = new ArrayList<>();
            int numOfNextRow = 0;
            for (int i = 0; i < numOfCurRow; i++) {
                TreeNode node = dq.pollFirst();
                if (node.left != null) {
                    nextRow.add(node.left.val);
                    dq.addLast(node.left);
                    ++ numOfNextRow;

                }
                if (node.right != null) {
                    nextRow.add(node.right.val);
                    dq.addLast(node.right);
                    ++ numOfNextRow;
                }
            }
            numOfCurRow = numOfNextRow;
            if (!nextRow.isEmpty())
                res.add(nextRow);
        }
        Collections.reverse(res);
        return res;
    }

}