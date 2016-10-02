/*
2016-10-2 16:44:26

https://leetcode.com/problems/powx-n/

Implement pow(x, n).

*/


class Solution {
public:
    double myPow(double x, int n) {
        
        double res = 1;
        
        if (x == 0)
            return 0;
        
        if (n == 0 || x == 1)
            return 1;
            
        //return pow(x, n);
            
        cout << pow(x, n) << endl;
        
        long long tmpn = abs((long long)n);//int的负最大值转成正会溢出，也不能用long，因为很多机器long和int一样大。
        
        cout << tmpn << endl;
        
        if (n < 0)
        {
            x = 1 / x;
        }
        
         cout << x << endl;
         
         if (x == -1)
         {
             return tmpn%2==0?1:-1;
         }
        
        for (long long i = 0; i < tmpn; ++ i)
        {
            res *= x;
            
            if (res == 0)
                return res;
                
        }
        
        return res;
    }
};