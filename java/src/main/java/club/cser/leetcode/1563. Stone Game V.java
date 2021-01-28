package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

class StoneGameV {
    public int stoneGameV(int[] stoneValue) {
        final int STONE_SIZE = stoneValue.length;
        int[][] dp = Stream.generate(() -> new int[STONE_SIZE + 1])
                .limit(STONE_SIZE + 1).toArray(int[][]::new);
//        for (int i = 0; i < STONE_SIZE; i++) {
//            dp[i][i] =
//        }
        for (int interval = 2; interval <= STONE_SIZE; interval++) {
            for (int begIndex = 0; begIndex + interval <= STONE_SIZE; begIndex ++) {
                int tmpSum = Arrays.stream(stoneValue).skip(begIndex).limit(interval).sum();
                int accSum = 0;
                for (int k = begIndex + 1; k < begIndex + interval; k ++) {
                    accSum += stoneValue[k - 1];
                    if (accSum == tmpSum - accSum) {
                        dp[begIndex][begIndex + interval] =
                                Math.max(dp[begIndex][begIndex + interval],
                                        accSum + Math.max(dp[begIndex][k], dp[k][begIndex + interval]));
                    } else if (accSum < tmpSum - accSum) {
                        dp[begIndex][begIndex + interval] =
                                Math.max(dp[begIndex][begIndex + interval],accSum + dp[begIndex][k]);
                    } else {
                        dp[begIndex][begIndex + interval] =
                                Math.max(dp[begIndex][begIndex + interval],tmpSum - accSum + dp[k][begIndex + interval]);
                    }
                }

//                System.out.println(String.format("dp[%d][%d] = %d, tmpSum = %d", begIndex, begIndex + interval, dp[begIndex][begIndex + interval], tmpSum));
            }
        }

//        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[0][STONE_SIZE];

    }

    public int stoneGameV1(int[] stoneValue) {
        final int STONE_SIZE = stoneValue.length;
        int[][] dp = Stream.generate(() -> new int[STONE_SIZE + 1])
                .limit(STONE_SIZE + 1).toArray(int[][]::new);
        int[] prefixSum = new int[STONE_SIZE + 1];
        for (int i = STONE_SIZE - 1; i >= 0; i --) {
            prefixSum[i] = stoneValue[i] + prefixSum[i + 1];
        }
        for (int interval = 2; interval <= STONE_SIZE; interval++) {
            for (int begIndex = 0; begIndex + interval <= STONE_SIZE; begIndex ++) {
                for (int k = begIndex + 1; k < begIndex + interval; k ++) {
                    int leftSum = prefixSum[begIndex] - prefixSum[k];
                    int rightSum = prefixSum[k] - prefixSum[begIndex + interval];
                    if (leftSum == rightSum) {
                        dp[begIndex][begIndex + interval] =
                                Math.max(dp[begIndex][begIndex + interval],
                                        leftSum + Math.max(dp[begIndex][k], dp[k][begIndex + interval]));
                    } else if (leftSum < rightSum) {
                        dp[begIndex][begIndex + interval] =
                                Math.max(dp[begIndex][begIndex + interval],leftSum + dp[begIndex][k]);
                    } else {
                        dp[begIndex][begIndex + interval] =
                                Math.max(dp[begIndex][begIndex + interval],rightSum + dp[k][begIndex + interval]);
                    }
//                    System.out.println(String.format("dp[%d][%d] = %d, tmpSum = %d", begIndex, begIndex + interval, dp[begIndex][begIndex + interval], leftSum + rightSum));

                }

            }
        }

//        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[0][STONE_SIZE];

    }
}