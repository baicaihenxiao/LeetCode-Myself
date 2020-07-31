package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeInorderTraversalTest {

    BinaryTreeInorderTraversal s;

    @Before
    public void init() {
        s = new BinaryTreeInorderTraversal();
    }

    public TreeNode createTreeNode1() {
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
        return root;
    }

    @Test
    public void basicTest1() {
        TreeNode root = createTreeNode1();
        List<Integer> res = Arrays.asList(1, 3, 2);

        Assert.assertEquals(res, s.inorderTraversal(root));
        Assert.assertEquals(res, s.inorderMorrisTraversal(root));
    }

}
