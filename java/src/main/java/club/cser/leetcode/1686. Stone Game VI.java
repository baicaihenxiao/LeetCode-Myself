package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        final int N = aliceValues.length;
        int[] values = IntStream.range(0, N).map(i -> aliceValues[i] + bobValues[i]).sorted().toArray();
        int res = 0;
        for (int i = N - 1; i >= 0; i -= 2) {
            res += values[i];
        }
        res -= Arrays.stream(bobValues).sum();

        return Integer.compare(res, 0);
    }
}