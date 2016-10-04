/*
2016-10-4 21:51:49

https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

//space complexity O(n), time complexity O(n);


/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
		
		//vector<RandomListNode*> pointer[2];
		unordered_map<RandomListNode*, RandomListNode*> pmap;
		
		RandomListNode* iter = head;
		
		while (iter != nullptr)
		{
			pmap[iter] = new RandomListNode(iter->label);
			
			iter = iter->next;
			
		}
		
		pmap[nullptr] = nullptr;
		
		iter = head;
		
		while (iter != nullptr)
		{
			pmap[iter]->next = pmap[iter->next];
			pmap[iter]->random = pmap[iter->random];
			
			iter = iter->next;
		}
		
		return pmap[head];
    }
};