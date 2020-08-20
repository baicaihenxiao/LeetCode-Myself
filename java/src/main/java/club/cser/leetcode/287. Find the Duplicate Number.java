package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        int low = 1, high = nums.length; // high = nums.length - 1 也可以
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int n: nums) {
                if (n <= mid)
                    ++ cnt;
            }
            if (cnt <= mid)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];
        fast = nums[fast];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate3(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            long cnt1 = IntStream.range(1, nums.length).filter(n -> (n & mask) != 0).count();
            long cnt2 = Arrays.stream(nums).filter(n -> (n & mask) != 0).count();
            if (cnt2 > cnt1)
                res |= mask;
        }
        return res;
    }
}