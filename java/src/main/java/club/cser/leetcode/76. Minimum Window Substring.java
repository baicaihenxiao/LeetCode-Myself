package club.cser.leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if ("".equals(t) || "".equals(s))
            return "";

        //t转成hashmap，重复字符需要计算重复个数
        Map<Character, Integer> tMap = t.chars().mapToObj(i -> (char) i)
                .collect(Collectors.toMap(i -> i,  i -> 1, Integer::sum));
//        System.out.println(tMap);

        String res = "";
        int head = 0, tail = 0, notContainCounts = tMap.size();

        for (tail = 0; tail < s.length(); ++ tail) {
            char tCh =  s.charAt(tail);
            if (tMap.containsKey(tCh)) {
                tMap.replace(tCh, tMap.get(tCh) - 1);
                notContainCounts -= tMap.get(tCh) == 0 ? 1 : 0; //tCh这个字符在s中出现的次数已经满足了t的个数，是==0而不是<=0
            }

            // notContainCounts 变成0 表示此时head~tail已经包含了t的所有字符，增大head值
            if (notContainCounts == 0) {
                for ( ; head <= tail; ++ head) {
                    char hCh =  s.charAt(head);
                    if (tMap.containsKey(hCh)) {
                        tMap.replace(hCh, tMap.get(hCh) + 1);

                        if (tMap.get(hCh) == 1) { //head到某个位置时，如果去掉hCh这个字符，head~tail不再包含t。
                            notContainCounts = 1;
                            if (res.length() > (tail - head + 1) || "".equals(res)) {
                                res = s.substring(head, tail + 1);
                            }
                            ++ head;
                            break;
                        }
                    }
                }
            }
        }

        return res;

    }
}