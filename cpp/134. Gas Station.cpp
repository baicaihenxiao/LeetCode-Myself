/*
2016-9-19 18:27:54

https://leetcode.com/problems/gas-station/

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

*/
class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
		int sol = 0;
		int sum = 0;
		int beg = -1;
		
		for (int i = 0; i < gas.size(); ++ i)
		{
			sum += gas[i] - cost[i];
			sol += gas[i] - cost[i];
			
			if (sum < 0)
			{
				sum = 0;
				beg = i;
			}
		}
		
		if (sol < 0)
		{
			return -1;
		}
		

		
		return (beg + 1);
		
		
    }
};