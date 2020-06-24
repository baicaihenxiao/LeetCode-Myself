package club.cser.leetcode;

class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        ListNode cur = head;

        // cur走k步
        while (k > 0) {
            -- k;
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = head;
            }
        }

        if (cur == head)
            return head;

        //找到距离尾部k个节点的位置
        ListNode res = head;
        while (cur.next != null) {
            res = res.next;
            cur = cur.next;
        }

        // 尾部接到头部
        cur.next = head;
        // 断开
        cur = res.next;
        res.next = null;

        return cur;

    }
}