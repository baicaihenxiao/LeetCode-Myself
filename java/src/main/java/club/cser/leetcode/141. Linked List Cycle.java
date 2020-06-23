package club.cser.leetcode;

class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}