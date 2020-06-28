package club.cser.leetcode;

import java.util.List;

class DesignLinkedList {

//   ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        [[],[1],[3],[1,2],[1],[1],[1]]
//    Output:
//            [null,null,null,null,2,null,3]
//
//    Explanation:
/*
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        linkedList.get(1);            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        linkedList.get(1);            // returns 3
    }
*/

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode pHead;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        pHead = new ListNode();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0)
            return -1;

        ListNode cur = pHead;
        int cnt = 0;

        while (cnt < index) {
            if (null == cur.next)
                return -1;
            cur = cur.next;
            ++ cnt;
        }

        if (cur.next == null)
            return -1;
        return cur.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode tmp = pHead.next;
        pHead.next = new ListNode(val);
        pHead.next.next = tmp;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode tmp = pHead;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0)
            return;

        ListNode cur = pHead;
        int cnt = 0;

        while (cnt < index) {
            if (null == cur.next)
                return;
            cur = cur.next;
            ++ cnt;
        }

        ListNode tmp = cur.next;
        cur.next = new ListNode(val);
        cur.next.next = tmp;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if (index < 0)
            return;

        ListNode cur = pHead;
        int cnt = 0;

        while (cnt < index) {
            if (null == cur.next)
                return;
            cur = cur.next;
            ++ cnt;
        }

        if (cur.next == null)
            return;

        cur.next = cur.next.next;
    }

}