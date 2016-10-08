/*
2016-10-8 17:16:32

https://leetcode.com/problems/lru-cache/

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/



//�Ľ��汾,ʹ��list.splice()����ת�ƽڵ㡣
//1.���ҡ����º�ɾ�����ǳ���ʱ�䡣
//2.��list(˫������)ά�����ʵ�ʱ��˳�򣬵���list����get��set�Ѵ���Ԫ��ʱ������ҪO(n)��
//3.����unordered_map����key��list�нڵ��iterator��������ʱ����ٲ��ҽڵ㡣


#include <unordered_map>
#include <list>
#include <iostream>
using namespace std;

class LRUCache{
public:
	LRUCache(int capacity) {
		this->capacity = capacity;
	}

	int get(int key) {
		//cout << "----" << key << endl;
		auto iter = cacheMap.find(key);
		if (iter == cacheMap.end())
		{
			//cout << "get not" << endl;
			return -1;
		}

		cacheList.splice(cacheList.begin(), cacheList, iter->second);

		return iter->second->value;
	}

	void set(int key, int value) {
		//cout << "----" << key << "-" << value<< endl;

		auto iter = cacheMap.find(key);

		if (iter != cacheMap.end())
		{
			iter->second->value = value;
			cacheList.splice(cacheList.begin(), cacheList, iter->second);
			return;
		}

		if (capacity == cacheList.size())
		{
			int delKey = cacheList.back().key;
			cacheList.pop_back();
			cacheMap.erase(delKey);
		}

		cacheList.push_front(CacheNode(key, value));

		cacheMap[key] = cacheList.begin();
		
	}

private:

	int capacity = 0;

	struct CacheNode
	{
		int key;
		int value;

		CacheNode(int key, int value) : key(key), value(value) {}
	};

	list<CacheNode> cacheList;
	unordered_map<int, list<CacheNode>::iterator> cacheMap;

};