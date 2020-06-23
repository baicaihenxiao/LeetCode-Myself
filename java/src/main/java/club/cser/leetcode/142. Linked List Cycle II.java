package club.cser.leetcode;

class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        slow = slow.next;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}