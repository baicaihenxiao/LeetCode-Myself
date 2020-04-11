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
}