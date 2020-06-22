package club.cser.leetcode;

class ReverseLinkedList {
    // 迭代方式
    public ListNode reverseList(ListNode head) {
        ListNode pHead = new ListNode();
        while (head != null) {
            // head向后走一步
            ListNode tmp = head;
            head = head.next;

            //更新结果pHead
            tmp.next = pHead.next;
            pHead.next = tmp;
        }
        return pHead.next;
    }

    // 递归方式
    public ListNode reverseList1(ListNode head) {
        ListNode res = new ListNode();
        revList(res, head);
        return res.next;
    }

    void revList(ListNode res, ListNode head) {
        if (head == null)
            return;

        // head向后走一步
        ListNode tmp = head;
        head = head.next;
        //更新结果pHead
        tmp.next = res.next;
        res.next = tmp;

        revList(res, head);
    }
}