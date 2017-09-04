/*
2017-9-4 14:44:00

https://leetcode.com/problems/zigzag-conversion/description/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
*/

class Solution {
public:
    string convert(string s, int numRows) {
        
        if (numRows == 0 || s.size() == 0)
            return string();

        if (numRows == 1)
            return s;

        int fir = numRows;
        int sec = numRows - 2;
        int cir = fir + sec;


        int sz = s.size();
        string res;

        for (int j = 0; j < sz; j += cir)
            res.push_back(s[j]);

        for (int row = 1; row < numRows - 1; ++ row)
        {
            int j = 0;
            while (true)
            {
                if (j * cir + row < sz)
                {
                    res.push_back(s[j * cir + row]);
                }
                else
                {
                    break;
                }

                if (j * cir + cir - row < sz)
                {
                    res.push_back(s[j * cir + cir - row]);
                }
                else
                {
                    break;
                }

                ++ j;
            }
        }

        for (int j = numRows - 1; j < sz; j += cir)
            res.push_back(s[j]);
        
        return res;
    }
};