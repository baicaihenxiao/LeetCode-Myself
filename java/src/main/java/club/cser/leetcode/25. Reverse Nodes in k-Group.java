package club.cser.leetcode;

class ReverseNodesinkGroup {
    // 头结点head, pHead为头结点的前一个节点
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = new ListNode(0, head); // 在链表头结点前面加一个pHead节点
        ListNode curpHead = pHead; // 每个要reverse的子链表的头结点的前一个节点
        ListNode nextpHead = new ListNode();
        ListNode nextHead = new ListNode();

        while (true) {
            ListNode curNode = curpHead;
            for (int i = 0; i < k; ++ i) {
                if (curNode.next == null)
                    return pHead.next;
                curNode = curNode.next;
            }
            nextpHead = curpHead.next; // 下一个pHead节点为当前头结点(当前头结点倒过来变成最后一个，即是下一个头结点的前一个)
            nextHead = curNode.next; // 获得下一个头结点
            curNode.next = null; // 断开
            curpHead.next = reverseList(curpHead.next);
            nextpHead.next = nextHead; // 连接

            curpHead = nextpHead; // 更新pHead
        }
    }

    // 206. Reverse Linked List
    private ListNode reverseList(ListNode head) {
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