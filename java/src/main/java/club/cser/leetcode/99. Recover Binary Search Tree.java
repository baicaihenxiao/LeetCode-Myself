package club.cser.leetcode;

class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode firstRevese = null;
        TreeNode secondRevese = null;

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
                    // 发现逆序对
                    if (pre != null && pre.val > cur.val) {
                        // 可以简化，但这样好理解
                        if (firstRevese == null) { // 发现第一个逆序对，不知道是否有第二个逆序对，所以需要把2个数都存起来
                            firstRevese = pre;
                            secondRevese = cur;
                        } else { // 发现第二个逆序对，只存较小的数
                            secondRevese = cur;
                        }
                    }
                    pre = cur;

                    cur = cur.right;
                }
            } else {
                // 发现逆序对
                if (pre != null && pre.val > cur.val) {
                    if (firstRevese == null) { // 可以简化，但这样好理解
                        firstRevese = pre;
                        secondRevese = cur;
                    } else {
                        secondRevese = cur;
                    }
                }
                pre = cur;

                cur = cur.right;
            }
        }

        swapVal(firstRevese, secondRevese);
    }

    private void swapVal(TreeNode pre, TreeNode cur) {
        int tmp = pre.val;
        pre.val = cur.val;
        cur.val = tmp;
    }
}