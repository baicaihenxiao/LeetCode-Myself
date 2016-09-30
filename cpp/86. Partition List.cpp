/*
2016-10-1 02:24:57

https://leetcode.com/problems/partition-list/

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/


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
    ListNode* partition(ListNode* head, int x) {
        ListNode tmpHead(-1);
		tmpHead.next = head;
		ListNode* phead = &tmpHead;
		ListNode* less = phead;
		ListNode* greater = phead;
		
		while (greater->next != nullptr && greater->next->val < x)
		{
			greater = greater->next;
		}
		
		less = greater;
		
		while (greater->next != nullptr)
		{			
			while (greater->next != nullptr && greater->next->val < x)
			{
				greater = greater->next;
			}
			
			
			while (less->next != nullptr && less->next->val >= x)
			{
				less = less->next;
			}
			
			if (less->next == nullptr || greater->next == nullptr)
			{
				break;
			}
			
			insertBBeforeA(greater, less);
			
/* 			if (greater->next->next != less)
			{
				greater = less;
			} */
			
		}
		
		return phead->next;
    }
	
	static void insertBBeforeA(ListNode* a, ListNode* b)//insert b->next after a; a->m, b->tmpB->k ==> a->tmpB->m, b->k;
	{
		ListNode* tmpB = b->next;
		b->next = b->next->next;
		tmpB->next = a->next;
		a->next = tmpB;
		
	}
	
	static void exchange(ListNode* a, ListNode* b)//exchange a->next and b->next;
	{

		
		ListNode* tmpA = a->next;
		ListNode* tmpB = b->next->next;
		
		a->next = b->next;
		if (a->next != tmpA->next)
		{
			a->next->next = tmpA->next;
		}
		else//a->b->c->d, we should exchange b and c in this situation.
		{
			a->next->next = tmpA;
		}
		
		b->next = tmpA;
		b->next->next = tmpB;
		
		
	}
};