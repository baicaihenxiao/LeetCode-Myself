package club.cser.leetcode;

import java.util.Stack;

class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int tmpMax = 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = tmpMax;
            tmpMax = Math.max(tmpMax, height[i]);
        }
        tmpMax = 0; // rightMax
        for (int i = height.length - 1; i >= 0; i --) {
            int tmpWall = Math.min(leftMax[i], tmpMax);
            if (tmpWall > height[i])
                res += tmpWall - height[i];
            tmpMax = Math.max(tmpMax, height[i]);
        }
        return res;
    }

    public int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[stack.peek()] > height[i])
                stack.push(i);
            else {
                int tmpCur = height[stack.pop()];
                if (!stack.empty()) {
                    res += (i - stack.peek() - 1) * (Math.min(height[stack.peek()], height[i]) - tmpCur);
                }
                -- i;
            }
        }
        return res;
    }
}