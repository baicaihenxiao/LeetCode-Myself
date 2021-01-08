package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseRobberIIITest {
    private HouseRobberIII s;

    @Before
    public void init() {
        s = new HouseRobberIII();
    }

    private TreeNode createTreeNode1() {
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

    private TreeNode createTreeNode2() {
        /**
         *    1
         *   /
         *  5
         *   \
         *    2
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = null;
        root.left.left = null;
        root.left.right = new TreeNode(2);
        return root;
    }

    private TreeNode createTreeNode3() {
        /**
         *          4
         *         /
         *        1
         *       /
         *      2
         *     /
         *    3
         */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);


        return root;
    }


    @Test
    public void basicTest1() {
        TreeNode root = createTreeNode1();

        int res = 25;
        Assert.assertEquals(res, s.rob(root));
    }

    @Test
    public void basicTest2() {
        TreeNode root = createTreeNode2();

        int res = 5;
        Assert.assertEquals(res, s.rob(root));
    }

    @Test
    public void basicTest3() {
        TreeNode root = createTreeNode3();

        int res = 7;
        Assert.assertEquals(res, s.rob(root));
    }
}
