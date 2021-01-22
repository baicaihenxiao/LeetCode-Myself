package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

class StoneGameII {
    private int[] piles;
    private int[][] memory;
    public int stoneGameII(int[] piles) {
        this.piles = piles;
        memory = Stream.generate(() -> new int[piles.length]).limit(piles.length).toArray(int[][]::new);
        return (dfs(0, 1) + Arrays.stream(piles).sum()) / 2;
    }

    int dfs(int index, int M) {
        if (index == piles.length)
            return 0;
//        System.out.println(index + " " + M);
        // 如果算出来是0，还是会重新算
        if (memory[index][Math.min(M, piles.length - 1)] != 0)
            return memory[index][Math.min(M, piles.length - 1)];
        int maxStone = Integer.MIN_VALUE;
        int currentPick = 0;

        for (int i = 1; (i <= 2 * M) && (index + i - 1 < piles.length); i++) {
            currentPick += piles[index + i - 1];
            maxStone = Math.max(maxStone, currentPick - dfs(index + i, Math.max(M, i)));
        }
        memory[index][Math.min(M, piles.length - 1)] = maxStone;

//        System.out.println(String.format("%d %d %d", index, M, maxStone));

        return maxStone;
    }
}