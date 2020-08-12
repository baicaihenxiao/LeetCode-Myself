package club.cser.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Object, List<String>> groups = new HashMap<>();

        for (String str: strs) {
//            System.out.println(encode2(str));
            Object o = encode2(str);
            if (!groups.containsKey(o)) {
                groups.put(o, new ArrayList<String>());
            }
            groups.get(o).add(str);
        }
        res.addAll(groups.values());
        return res;

    }

    private Object encode1(String str) {
        StringBuilder sb = new StringBuilder("");
        str.chars().sorted().map(c -> (char)c).forEach(sb::appendCodePoint);
        return sb.toString();
    }

    private Object encode2(String str) {
        int[] chs = new int[26];
        str.chars().map(c -> c - 'a').forEach(c -> ++ chs[c]);
        StringBuilder sb = new StringBuilder("");
        IntStream.of(chs).forEach(c -> sb.append(c).append('#'));

        return sb.toString();
    }
}