package club.cser.leetcode;

import java.util.Arrays;

class StoneGameIII {

    private int[] stoneValue;
    private int[] memory;
    private int DEFAULT_VALUE = Integer.MIN_VALUE;
    private int MIN_PICK = 1;
    private int MAX_PICK = 3;


    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        this.memory = new int[stoneValue.length];
        Arrays.fill(this.memory, DEFAULT_VALUE);
        int res = dfs(0);

        return res > 0 ? "Alice" : (res == 0 ? "Tie" : "Bob");

    }

    int dfs(int index) {
        if (index == stoneValue.length)
            return 0;
        if (memory[index] != DEFAULT_VALUE)
            return memory[index];
        int maxStone = Integer.MIN_VALUE;
        int currentPick = 0;

        for (int i = MIN_PICK; (i <= MAX_PICK) && (index + i - 1 < stoneValue.length); i++) {
            currentPick += stoneValue[index + i - 1];
            maxStone = Math.max(maxStone, currentPick - dfs(index + i));
        }
        memory[index] = maxStone;

        return maxStone;
    }

    public String stoneGameIII_BottomUp(int[] stoneValue) {
        final int STONE_SIZE = stoneValue.length;
        int[] dp = new int[STONE_SIZE + 1];
        for (int i = STONE_SIZE - 1; i >= 0; i --) {
            int maxStone = Integer.MIN_VALUE;
            int currentPick = 0;

            for (int j = MIN_PICK; (j <= MAX_PICK) && (i + j - 1 < stoneValue.length); j ++) {
                currentPick += stoneValue[i + j - 1];
                maxStone = Math.max(maxStone, currentPick - dp[i + j]);
            }
            dp[i] = maxStone;

        }

        return dp[0] > 0 ? "Alice" : (dp[0] == 0 ? "Tie" : "Bob");

    }
}