package club.cser.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TreePostorderTraversalTest {

    @Test
    public void postorderTest() {
        /**
         *   1
         *    \
         *     2
         *    /
         *   3
         */

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        List<Integer> actualRes = new TreePostorderTraversal().postorderTraversal(root);

        Integer[]  expectRes = {3, 2, 1};

        Assert.assertArrayEquals(expectRes, actualRes.toArray());
    }

}
