//https://leetcode.com/problems/range-sum-of-bst/
//https://mp.weixin.qq.com/s/QHqkaVZhiJRiaUIWscUajw

package club.cser.leetcode;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class RangeSumOfBST {


    //前序遍历每一个节点来判断是否满足大小
    //用的是https://www.cser.club/tree#b%E5%8F%AA%E9%80%82%E5%90%88%E4%B8%AD%E5%BA%8F%E5%89%8D%E5%BA%8F%E9%81%8D%E5%8E%86
    public int rangeSumBST_NoRecursivePreorder(TreeNode root, int L, int R) {
        Stack<TreeNode> preorderStack = new Stack<>();
        int res = 0;
        TreeNode curIter = root;

        while (curIter != null || !preorderStack.empty()) {
            if (curIter != null) {
                if (curIter.val >= L && curIter.val <= R) {
                    res += curIter.val;
                }
                preorderStack.push(curIter);
                curIter = curIter.left;
            }  else {
                curIter = preorderStack.pop().right;
            }
        }
        return res;
    }

    //前序遍历，剪枝策略
    //用的是https://www.cser.club/tree#a%E5%8F%AA%E9%80%82%E5%90%88%E5%89%8D%E5%BA%8F%E9%81%8D%E5%8E%86
    public int rangeSumBST_NoRecursivePreorder_WithBranchCut(TreeNode root, int L, int R) {
        Stack<TreeNode> preorderStack = new Stack<>();
        int res = 0;

        preorderStack.push(root);

        while (!preorderStack.empty()) {

            TreeNode topNode = preorderStack.pop();

            if (topNode == null) {
                continue;
            }

            if (topNode.val < L) {
                preorderStack.push(topNode.right);
            } else if (topNode.val > R) {
                preorderStack.push(topNode.left);
            } else {
                res += topNode.val;
                preorderStack.push(topNode.right);
                preorderStack.push(topNode.left);
            }

        }
        return res;
    }
}