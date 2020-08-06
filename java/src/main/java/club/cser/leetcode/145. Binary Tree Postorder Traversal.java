package club.cser.leetcode;

import java.util.*;

enum TraversalOrder {
    PREORDER(0), //前序对应回溯根节点的次数为0
    INORDER(1),
    POSTORDER(2);

    private Integer code;

    TraversalOrder(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}


// https://leetcode.wang/leetcode-145-Binary-Tree-Postorder-Traversal.html
class TreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        return universalOrderTraversal(root, TraversalOrder.POSTORDER);
    }

    public List<Integer> universalOrderTraversal(TreeNode root, TraversalOrder traversalOrder) {
        List<Integer> res = new ArrayList<>();//遍历结果
        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> trStack = new Stack<>(); //<节点，访问节点(回溯)次数>

        if (root != null) {
            trStack.push(new AbstractMap.SimpleEntry<>(root, 0));//第一次放入stack里，没被取出(回溯)过，所以值为0
        }

        while (!trStack.empty()) {
            HashMap.Entry<TreeNode, Integer> peekNode = trStack.peek();

            if (peekNode.getKey() == null) {
                trStack.pop();//节点为空，不存在，弹出
            } else {
                //根据节点访问(回溯)的次数与遍历方式是否匹配，来判断是否需要访问节点数据
                if (peekNode.getValue().equals(traversalOrder.getCode())) {
                    res.add(peekNode.getKey().val);
                }
                switch (peekNode.getValue()) {
                    case 0:
                        trStack.push(new AbstractMap.SimpleEntry<>(peekNode.getKey().left, 0));
                        break;
                    case 1:
                        trStack.push(new AbstractMap.SimpleEntry<>(peekNode.getKey().right, 0));
                        break;
                    case 2:
                        trStack.pop();//子节点都被访问过了，该节点也无用了
                        break;
                    default:
                        throw new IllegalArgumentException("invalid access times");
                }
                peekNode.setValue(peekNode.getValue() + 1); //回溯次数+1
            }
        }
        return res;
    }


    // https://leetcode.wang/leetcode-145-Binary-Tree-Postorder-Traversal.html#%E8%A7%A3%E6%B3%95%E4%B8%89-%E8%BD%AC%E6%8D%A2%E9%97%AE%E9%A2%98
    // 根 => 右 => 左 reverse即是后序遍历的顺序。
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode top = s.pop();

            if (null != top) {
                res.add(top.val);
                s.push(top.left);
                s.push(top.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversal11(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>(); // 用链表addFirst不用reverse，更快

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode top = s.pop();

            if (null != top) {
                res.addFirst(top.val);
                s.push(top.left);
                s.push(top.right);
            }
        }
        return res;
    }

    // 每个节点放2次到栈里，根据弹出的节点和栈顶节点是否相等来判断第几次回溯根。
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur == null)
                continue;
            if (!s.isEmpty() && cur == s.peek()) {
                s.push(cur.right);
                s.push(cur.right);
                s.push(cur.left);
                s.push(cur.left);
            } else {
                res.add(cur.val);
            }
        }
        return res;
    }


    // https://en.wikipedia.org/wiki/Tree_traversal#Post-order
    public List<Integer> postorderTraversal3(TreeNode root) {

        Stack<TreeNode> path = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode iter = root;
        TreeNode lastVisited = null;

        while (null != iter || !path.empty()) {

            if (null != iter) {
                path.push(iter);
                iter = iter.left;
                continue;
            }

            TreeNode cur = path.peek();

            // 有右孩子节点，且不是从右孩子回来的
            if (null != cur.right && lastVisited != cur.right) {
                iter = cur.right;
            } else {
                path.pop();
                res.add(cur.val);
                lastVisited = cur;
            }
        }
        return res;
    }


    public List<Integer> postorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = new TreeNode();
        cur.left = root;

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
                    addMorrisList(cur.left, res);
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }
        }

        return res;
    }

    private void addMorrisList(TreeNode begin, List<Integer> res) {
        begin = reverseList(begin);
        TreeNode iter = begin;

        while (null != iter) {
            res.add(iter.val);
            iter = iter.right;
        }
        // 恢复树结构，不恢复也可以
        reverseList(begin);
    }

    // 206. Reverse Linked List
    private TreeNode reverseList(TreeNode head) {
        TreeNode pHead = new TreeNode();
        while (head != null) {
            // head向后走一步
            TreeNode tmp = head;
            head = head.right;

            //更新结果pHead
            tmp.right = pHead.right;
            pHead.right = tmp;
        }
        return pHead.right;
    }




}