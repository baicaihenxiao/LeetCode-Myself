package club.cser.leetcode;

import java.util.ArrayList;
import java.util.List;

class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);

        for (int i = 1; i < s.length(); ++ i) {
            int tmp = (s.charAt(i -1) - '0') * 10 + s.charAt(i) - '0';

            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i) == '0') {
                    return 0;
                }
                dp.add(dp.get(i));
            } else {
                if (s.charAt(i) == '0') {
                    if (tmp > 26)
                        return 0;
                    dp.add(dp.get(i-1));
                } else {
                    if (tmp > 26)
                        dp.add(dp.get(i));
                    else
                        dp.add(dp.get(i-1) + dp.get(i));
                }

            }

        }

        return dp.get(s.length());
    }
    
}