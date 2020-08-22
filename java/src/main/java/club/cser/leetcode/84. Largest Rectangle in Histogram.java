package club.cser.leetcode;

import java.util.Stack;

class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> hist = new Stack<>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!hist.isEmpty() && (heights[i] <= heights[hist.peek()])) {
                int top = hist.pop();
                res = Math.max(res, heights[top] * (hist.isEmpty() ? i : i - hist.peek() - 1));
            }
            hist.push(i);
        }
        while (!hist.isEmpty()) {
            int top = hist.pop();
            res = Math.max(res, heights[top] * (hist.isEmpty() ? heights.length : heights.length - hist.peek() - 1));
        }
        return res;
    }



    // 这个思路是，每个点找出左边能够延伸和右边能够延伸的宽度，加起来即可.
    // 但是计算方法错了，对于{4,2,0,3,2,4,3,4}，答案是10，但是这个统计的是 4 3 4 为9
    public int largestRectangleAreaERROR(int[] heights) {
        if (heights.length == 0)
            return 0;
        int[] width = new int[heights.length];
        int tmpWidth = 0;
        int preHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > preHeight) {
                width[i] = 1;
                tmpWidth = 1;
            } else {
                width[i] = ++ tmpWidth;
            }
            preHeight = heights[i];
        }
        tmpWidth = 0;
        preHeight = 0;
        int res = 0;
        for (int i = heights.length - 1; i >= 0; i --) {
            if (heights[i] > preHeight) {
                tmpWidth = 0;
            } else {
                width[i] += ++ tmpWidth;
            }
            preHeight = heights[i];
            res = Math.max(res, width[i] * heights[i]);
        }
        return res;
    }
}