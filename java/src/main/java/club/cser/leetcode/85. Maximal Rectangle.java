package club.cser.leetcode;

import java.util.Stack;

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (0 == matrix.length)
            return 0;
        int[] heights = new int[matrix[0].length + 1];
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    // 84. Largest Rectangle in Histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> hist = new Stack<>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!hist.isEmpty() && (heights[i] <= heights[hist.peek()])) {
                int top = hist.pop();
                res = Math.max(res, heights[top] * (hist.isEmpty() ? i : i - hist.peek() - 1));
            }
            hist.push(i);
        }

        return res;
    }
}