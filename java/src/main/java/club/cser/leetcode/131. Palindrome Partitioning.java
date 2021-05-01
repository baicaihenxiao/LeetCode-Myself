package club.cser.leetcode;

import club.cser.commons.Converter;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    private int NUM = 0;
    private boolean[][] dp;
    private List<List<String>> res;
    private List<String> curList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        NUM = s.length();
        dp =  new boolean[NUM][NUM];
        res = new ArrayList<>();
        for (int i = 0; i < NUM; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i <= NUM; i++) {
            // dp[i - 1][i - 1] = true; 不能放在这里，不满足一个点的左下dp[j + 1][j + i - 1]已经被计算。
            for (int j = 0; j < NUM - i; j++) {
                if (s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1])) {
                    dp[j][j + i] = true;
                }
            }
        }
//        System.out.println(Converter.charToString(dp));

        dfs(s, 0);

        return res;
    }

    private void dfs(String s, int start) {
        if (start == NUM) {
            res.add(new ArrayList<>(curList));
        }

        for (int i = start; i < NUM; i++) {
            if (dp[start][i]) {
                curList.add(s.substring(start, i + 1));
                dfs(s, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }
}