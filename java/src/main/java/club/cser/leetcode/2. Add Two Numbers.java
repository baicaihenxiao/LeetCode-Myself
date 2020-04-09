package club.cser.leetcode;//2018-05-01 13:39:56


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res, tail;

        res = new ListNode(-1);
        tail = res;

        int carry = 0;

        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode(0);

            tmp.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            tail.next = tmp;
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode tmp = new ListNode(0);

            tmp.val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;

            tail.next = tmp;
            tail = tail.next;

            l1 = l1.next;

        }

        while (l2 != null) {
            ListNode tmp = new ListNode(0);

            tmp.val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;

            tail.next = tmp;
            tail = tail.next;

            l2 = l2.next;

        }

        if (carry == 1) {
            tail.next = new ListNode(1);
        }

        return res.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}