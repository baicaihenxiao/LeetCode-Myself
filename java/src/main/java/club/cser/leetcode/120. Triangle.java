package club.cser.leetcode;

import java.util.Arrays;
import java.util.List;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] res = new int[triangle.size() + 1];
        Arrays.fill(res, 0);

        for (int i = triangle.size(); i > 0; -- i) {
            for (int j = 0; j < i; ++ j) {
                res[j] = triangle.get(i - 1).get(j) + Math.min(res[j], res[j + 1]);
            }
        }

        return res[0];
    }
}