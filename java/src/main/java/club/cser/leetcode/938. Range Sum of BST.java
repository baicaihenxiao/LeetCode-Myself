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
}