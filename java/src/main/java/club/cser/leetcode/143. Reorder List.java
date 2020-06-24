package club.cser.leetcode;

class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode fast = head.next;
        ListNode slow = head;

        // 找到中间点
        while (fast != slow) {
            if (fast == null || fast.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next;
        }

        // 第二部分reverse
        ListNode secondPart = slow.next;
        slow.next = null;
        secondPart = reverseList(secondPart);

        // 构建结果
        ListNode firstPart = head;
        while (secondPart != null) {
            ListNode tmp = secondPart.next;

            secondPart.next = firstPart.next;
            firstPart.next = secondPart;

            secondPart = tmp;
            firstPart = firstPart.next.next;
        }
    }

    // 206. Reverse Linked List
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
}