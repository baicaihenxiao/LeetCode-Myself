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
    ListNode* reverseKGroup(ListNode* head, int k) {
        
		if (head == nullptr || k == 0 || k == 1)
		{
			return head;
		}
		
		ListNode dummy(0);
		ListNode* phead = &dummy;
		
		phead->next = head;
		
		ListNode* begin = phead;
		ListNode* end;
		
		int i = 0;
		
		while (true)
		{
			
			end = begin;
			
			for (i = 0; i < k; ++ i)
			{
				if (end->next == nullptr)//�����⣬������end->next���������.
				{
					break;
				}
				
				end = end->next;
			}
			
			
			
		}
		
		
    }
};