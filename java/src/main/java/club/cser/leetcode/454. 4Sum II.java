package club.cser.leetcode;

import java.util.HashMap;
import java.util.Map;

class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> AB = new HashMap<>();
        Map<Integer, Integer> CD = new HashMap<>();

        for (int i = 0; i < A.length; ++ i) {
            for (int j = 0; j < A.length; ++ j) {
                AB.computeIfPresent(A[i] + B[j],  (key, val) -> ++ val);
                AB.computeIfAbsent(A[i] + B[j], key -> 1);

                CD.computeIfPresent(C[i] + D[j],  (key, val) -> ++ val);
                CD.computeIfAbsent(C[i] + D[j], key -> 1);
            }
        }

        int res = 0;
        for (Integer k : AB.keySet()) {
            res += AB.get(k) * CD.getOrDefault(-k, 0);
        }

        return res;
    }
}