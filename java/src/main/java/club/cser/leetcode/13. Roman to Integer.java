package club.cser.leetcode;// 2019-7-12 11:10:01
// https://leetcode.com/problems/roman-to-integer/

// 参考这个里面的评论，从后往前面扫，写得更优雅
// https://leetcode.com/problems/roman-to-integer/discuss/6529/My-solution-for-this-question-but-I-don't-know-is-there-any-easier-way
class RomanToInteger {
    public int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int res = 0;

        int first = romanCh2Int(s.charAt(0));
        int second = 0;

        for (int i = 1; i < s.length(); ++ i) {
            second = romanCh2Int(s.charAt(i));
            
            if (first == 0) {
                first = second;
                continue;
            }
            
            if (first < second) {
                res += second - first;
                first = 0;
            } else {
                res += first;
                first = second;
            }
        }
        
        res += first;
        
        return res;
    }

    public int romanCh2Int(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;

            default:
                throw new IllegalArgumentException();

        }
    }
}