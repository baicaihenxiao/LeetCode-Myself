package club.cser.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CopyListwithRandomPointer {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // map 存储原链表的 节点与下标 对应关系
    // list 存储返回的新链表
    public Node copyRandomList(Node head) {
        List<Node> nodes = new ArrayList<>();
        Map<Node, Integer> indexOfNodes = new HashMap<>();
        Node cur = head;
        int cnt = 0;

        while (cur != null) {
            nodes.add(new Node(cur.val));
            indexOfNodes.put(cur, cnt ++);
            cur = cur.next;
        }

        nodes.add(null);
        indexOfNodes.put(null, cnt);

        cur = head;
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
            nodes.get(i).random = nodes.get(indexOfNodes.get(cur.random));
            cur = cur.next;
        }

        return nodes.get(0);
    }


    // 不用额外空间，在原链表后面加节点
    public Node copyRandomListWithoutExtraSpace(Node head) {
        if (head == null)
            return null;

        // 每个节点后面复制一个节点
        Node cur = head;
        while (cur != null) {
            Node duplica = new Node(cur.val);
            duplica.next = cur.next;
            duplica.random = cur.random;
            cur.next = duplica;
            cur = cur.next.next;
        }

        // 对复制节点的random赋值
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 对复制节点的next赋值，并恢复原链表
        cur = head;
        Node res = head.next, curRes = res;
        while (cur != null) {
            cur.next = curRes.next;
            cur = cur.next;
            if (curRes.next != null) {
                curRes.next = cur.next;
                curRes = curRes.next;
            }
        }

        return res;
    }
}