package club.cser.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int curListNum = lists.length;

        if (curListNum == 0)
            return null;

        while (curListNum > 1) {
            int i = 0;
            for (; i < curListNum / 2; ++ i) {
                lists[i] = mergeTwoList(lists[2 * i], lists[2 * i + 1]);
            }

            if (curListNum % 2 == 1) {
                lists[i] = lists[curListNum - 1];
            }

            curListNum = curListNum / 2 + curListNum % 2;
        }

        return lists[0];
    }

    ListNode mergeTwoList(ListNode list1, ListNode list2) {

        ListNode pHead = new ListNode();
        ListNode cur = pHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 == null)
            cur.next = list2;
        else
            cur.next = list1;

        return pHead.next;
    }

}