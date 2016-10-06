/*
2016-10-6 23:17:30

https://leetcode.com/problems/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/



/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
 
//假设从head到入口点的距离为T,入口点到相遇点的距离为a，从相遇点到链表结束点(环中入口点的前一个点)的距离为b，环的长度为T, 则有 T = a + b +１；(加一是因为从链表结束点到入口点还有一条边的距离);
//第一次相遇时右侧等式成立: 2(R + a + k1*T) = R + a + k2*T;
//则 R + a = (k2 - 2*k1) * T >= T;//若 R+a==0，则说明只有一个点，入口就是head，返回的始终是head，无需单独判断。
//故 R = (k - 1) * T + (T - a) = (k - 1)T + b + 1;
//根据上一行等式可知，在onestep和twostep第一次相遇的地点，onestep再走R步就到达了环的入口（因为相遇点距入口距离为a，a+b+1刚好走到入口点，再转(k-1)圈回到入口点）。
//我们要求的即为R，令指针res走R步到入口处刚好和onestep走R步相遇，此时相遇正好在环入口处，即为所求。
 
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        
		if (head == nullptr || head->next == nullptr)
		{
			return nullptr;
		}
		
		ListNode* onestep = head;
		ListNode* twostep = head->next;
		
		//1.judge whether a cycle exists;
		while (true)
		{
			if (onestep == twostep)
			{
				break;
			}
			
			onestep = onestep->next;
			
			if (twostep == nullptr || twostep->next == nullptr)
			{
				return false;
			}
			
			twostep = twostep->next->next;			
		}
		
		ListNode* res = head;
		onestep = onestep->next;
		while (onestep != res)
		{
			res = res->next;
			onestep = onestep->next;
		}
		
		
		return res;
		
		
		
    }
};