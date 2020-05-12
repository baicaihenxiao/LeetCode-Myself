package club.cser.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>(k);
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; ++ i) {
            while (!dq.isEmpty() && (nums[dq.getLast()] <= nums[i]))
                dq.removeLast();

            if (!dq.isEmpty() && (dq.getFirst() == i - k))
                dq.removeFirst();

            dq.addLast(i);

            if (i >= k - 1)
                res[i - k + 1] = nums[dq.getFirst()];
        }

        return res;
    }

}