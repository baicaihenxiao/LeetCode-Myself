/*
2016-10-9 00:36:13

https://leetcode.com/problems/reorder-list/

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/


//1.onestep+twostep的方法找到中间的节点；
//2.将后半段链表reverse;
//3.合并两个链表.


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        
		if (head == nullptr || head->next == nullptr)
			return;
		
		//1.onestep+twostep的方法找到中间的节点；
		ListNode* middle = head;
		ListNode* end = head->next;
		
		while (end != nullptr && end->next != nullptr)//前半段链表的长度和后半段相等或者大一。
		{
			middle = middle->next;
			end = end->next->next;
		}
		
		//2.将后半段链表reverse;
		ListNode* head2 = middle;
		ListNode* end2 = middle->next;
		while (end2->next)
		{
			ListNode* tmp = head2->next;
			head2->next = end2->next;
			end2->next = end2->next->next;
			head2->next->next = tmp;
		}
		
		//3.合并两个链表.
		head2 = middle->next;
		middle->next = nullptr;
		
		while (head2)
		{
			ListNode* tmp = head2->next;
			head2->next = head->next;
			head->next = head2;
			head2 = tmp;
			head = head->next->next;
		}
		
    }
};