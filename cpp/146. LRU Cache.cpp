/*
2016-10-8 17:16:32

https://leetcode.com/problems/lru-cache/

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/




//1.查找、更新和删除都是常数时间。
//2.用list(双向链表)维护访问的时间顺序，但是list调用get和set已存在元素时查找需要O(n)。
//3.故用unordered_map保存key和list中节点的iterator，来常数时间快速查找节点。
//这里做的不好的是移动元素时，是先把元素删掉，再重新创建一个节点插入到新位置，待改进。

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
		CacheNode tmp(key, iter->second->value);//iter->second对应的是cacheList元素(CacheNode)的迭代器.
		cacheList.erase(iter->second);
		cacheList.push_front(tmp);
		cacheMap[key] = cacheList.begin();

	/*	for (auto i: cacheMap)
		{
			cout << "get" << i.first << " " << i.second->value << endl;
		}*/

		return cacheList.front().value;
	}

	void set(int key, int value) {
		//cout << "----" << key << "-" << value<< endl;

		auto iter = cacheMap.find(key);

		if (iter != cacheMap.end())
		{
			cacheList.erase(iter->second);
		}

		if (capacity == cacheList.size())
		{
			int delKey = cacheList.back().key;
			cacheList.pop_back();
			cacheMap.erase(delKey);
		}

		cacheList.push_front(CacheNode(key, value));

		cacheMap[key] = cacheList.begin();
		
		/*cout << cacheList.begin()->key << " " << (cacheList.begin())->value << endl;
		if ((++cacheList.begin()) != cacheList.end())
		{
			cout << (++cacheList.begin())->key << " " << (++cacheList.begin())->value << endl;
		}
		cout << endl;*/
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