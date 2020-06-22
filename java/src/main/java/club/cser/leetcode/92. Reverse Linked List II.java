package club.cser.leetcode;

class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 前面增加一个节点
        ListNode pHead = new ListNode(0, head);

        int count = 0;

        while (count + 1 != m) {
            ++ count;
            pHead = pHead.next;
        }

        // cur 此时指向 m
        ListNode cur = pHead.next;
        // 保存m，反转后m为最后一个，需要为m.next赋值
        ListNode tmpTail = pHead.next;
        // 置为null 因为要用tmp.next = pHead.next;
        pHead.next = null;

        while (cur != null && (count != n)) {
            // cur向后走一步
            ListNode tmp = cur;
            cur = cur.next;
            ++ count;

            //更新结果pHead
            tmp.next = pHead.next;
            pHead.next = tmp;
        }

        // 为m.next赋值
        if (tmpTail != null)
            tmpTail.next = cur;

        if (m == 1)
            return pHead.next;
        else
            return head;

    }
}