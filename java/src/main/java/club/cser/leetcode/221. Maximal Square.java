package club.cser.leetcode;

class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (null == matrix || 0 == matrix.length)
            return 0;

        int[][] dp = new int[2][matrix[0].length + 1];
        int curRow = 1;
        int preRow = 0;
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if ('0' == matrix[i][j]) {
                    dp[curRow][j + 1] = 0;
                    continue;
                }

                // dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
                dp[curRow][j + 1] = Math.min(dp[curRow][j], dp[preRow][j]);
                dp[curRow][j + 1] = Math.min(dp[curRow][j + 1], dp[preRow][j + 1]);
                ++ dp[curRow][j + 1];

                res = Math.max(res, dp[curRow][j + 1]);
            }
            curRow ^= 1; // swap 0 and 1
            preRow ^= 1;
        }
        return res * res;
    }

}