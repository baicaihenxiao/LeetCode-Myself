package club.cser.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class RangeSumOfBSTTest {


    static final Logger LOGGER = LogManager.getLogger(RangeSumOfBSTTest.class);

    public TreeNode createTreeNode1() {
        /**
         *   10
         *    \
         *     20
         *    /
         *   15
         */

        TreeNode root = new TreeNode(10);
        root.left = null;
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = null;
        return root;
    }


    @Test
    public void rangeSumBST_NoRecursivePreorder_Test() {
        TreeNode root = createTreeNode1();

        int res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder(root, 10, 20);
        Assert.assertEquals(45, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder(root, 10, 15);
        Assert.assertEquals(25, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder(root, 15, 20);
        Assert.assertEquals(35, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder(root, 1, 13);
        Assert.assertEquals(10, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder(root, 40, 50);
        Assert.assertEquals(0, res);

    }

    @Test
    public void rangeSumBST_NoRecursivePreorder_WithBranchCut_Test() {
        TreeNode root = createTreeNode1();

        int res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder_WithBranchCut(root, 10, 20);
        Assert.assertEquals(45, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder_WithBranchCut(root, 10, 15);
        Assert.assertEquals(25, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder_WithBranchCut(root, 15, 20);
        Assert.assertEquals(35, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder_WithBranchCut(root, 1, 13);
        Assert.assertEquals(10, res);

        res = new RangeSumOfBST().rangeSumBST_NoRecursivePreorder_WithBranchCut(root, 40, 50);
        Assert.assertEquals(0, res);

    }
}
