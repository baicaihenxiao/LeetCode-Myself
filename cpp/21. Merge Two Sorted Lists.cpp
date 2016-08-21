/*
2016��4��30��21:43:17

21. Merge Two Sorted Lists   My Submissions QuestionEditorial Solution
Total Accepted: 124927 Total Submissions: 352351 Difficulty: Easy
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Subscribe to see which companies asked this question

*/


 //Definition for singly-linked list.
 struct ListNode {
     int val;
     ListNode *next;
	 ListNode(int x) : val(x) { this->next = nullptr; }
 };

class Solution {//����ⷨ��̫�������⣬��Ϊ���Լ�������node����û��ʹ��ԭ����node��
public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		ListNode *tmpNode1 = l1, *tmpNode2 = l2, *resNode = 0, *tmpResNode = 0;

		resNode = new ListNode(0);//�ȴ���һ�����õĽڵ�����Ϊ������˵Ļ��޷�����ͷ�ڵ㣻
		tmpResNode = resNode;

		while (tmpNode1 != 0 && tmpNode2 != 0)
		{
			if (tmpNode1->val < tmpNode2->val)
			{
				tmpResNode->next = new ListNode(tmpNode1->val);
				tmpResNode = tmpResNode->next;
				tmpNode1 = tmpNode1->next;
			}
			else
			{
				tmpResNode->next = new ListNode(tmpNode2->val);
				tmpResNode = tmpResNode->next;
				tmpNode2 = tmpNode2->next;
			}
		}

		while (tmpNode1 != 0)
		{
			tmpResNode->next = new ListNode(tmpNode1->val);
			tmpResNode = tmpResNode->next;
			tmpNode1 = tmpNode1->next;
		}

		while (tmpNode2 != 0)
		{
			tmpResNode->next = new ListNode(tmpNode2->val);
			tmpResNode = tmpResNode->next;
			tmpNode2 = tmpNode2->next;
		}

		return resNode->next;
	}
};