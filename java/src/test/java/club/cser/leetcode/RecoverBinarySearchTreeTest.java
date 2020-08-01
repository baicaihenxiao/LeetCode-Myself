package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RecoverBinarySearchTreeTest {

    RecoverBinarySearchTree s;

    // 校验recover的结果
    BinaryTreeInorderTraversal inorderTraversal;

    @Before
    public void init() {
        s = new RecoverBinarySearchTree();
        inorderTraversal = new BinaryTreeInorderTraversal();
    }

    public TreeNode createTreeNode2() {
        /**
         *    1
         *   /
         *  3
         *   \
         *    2
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = null;
        root.left.left = null;
        root.left.right = new TreeNode(2);
        return root;
    }



    @Test
    public void basicTest1() {
        /**
         *    1
         *   /
         *  3
         *   \
         *    2
         *
         *  ==》
         *
         *    3
         *   /
         *  1
         *   \
         *    2
         */
        TreeNode root = createTreeNode2();
        List<Integer> res = Arrays.asList(1, 2, 3);
        s.recoverTree(root);
        Assert.assertEquals(res, inorderTraversal.inorderTraversal(root));
    }

}
