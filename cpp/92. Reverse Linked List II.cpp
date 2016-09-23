/*
2016-9-23 21:08:46

https://leetcode.com/problems/reverse-linked-list-ii/

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/


//这个题目对链表的理解 考察比较好


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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        
		if (head == nullptr || (m == n))
			return head;
		
		ListNode *a = nullptr, *b = nullptr, *c = nullptr, *d = nullptr;
		
		ListNode* pre = nullptr;
		ListNode* cur = nullptr;
		ListNode* nex = nullptr;
		
		int i = 0;
		
		if (m == 1)
		{
			a = nullptr;
			b = head;
			
			++ i;
		}
		else
		{
			a = head;
			b = head->next;
			
			++ i;
			
			while ((++ i) != m)
			{
				a = a->next;
				b = b->next;
			}
		}
		
		pre = b;
		cur = b->next;
		
		while ((++ i) != n)
		{
			nex = cur->next;
			cur->next = pre;
			pre = cur;
			cur = nex;
		}
		
		c = cur;
		d = cur->next;
		
		cur->next = pre;
		
		
		b->next = d;
		
		if (a != nullptr)
		{
			a->next = c;
			
			return head;
		}
		else
		{
			return c;
		}
		
		
    }
	
	
};