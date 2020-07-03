package club.cser.leetcode;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        bucketsort(nums);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }

    private void bucketsort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int bucketCount = nums.length; // 有几个桶
        int bucketGap = (max - min) / bucketCount + 1; // 桶大小


        List<Integer>[] buckets = Stream.generate(ArrayList<Integer>::new).limit(bucketCount).toArray(ArrayList[]::new);

        for (int i: nums) {
            buckets[ (i - min) / bucketGap ].add(i);
        }

        int i = 0;

        for (List<Integer> bucket: buckets) {
            bucket.sort(Comparator.naturalOrder());
//            System.out.println(bucket);
            System.arraycopy(bucket.stream().mapToInt(e -> e).toArray(), 0, nums, i, bucket.size());
            i += bucket.size();
        }

//        System.out.println(Arrays.toString(nums));
    }


    public int maximumGap1(int[] nums) {
        if (nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int bucketGap = Math.max(1,  (max - min) / (nums.length - 1)); // 桶大小
        int bucketCount = (max - min) / bucketGap + 1; // 有几个桶


        int[] bucketMax = new int[bucketCount];
        int[] bucketMin = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];

        for (int i: nums) {
            int bucketNo = (i - min) / bucketGap;
            if (!bucketUsed[bucketNo]) {
                bucketMax[bucketNo] = i;
                bucketMin[bucketNo] = i;
                bucketUsed[bucketNo] = true;
            } else {
                bucketMin[bucketNo] = Math.min(bucketMin[bucketNo], i);
                bucketMax[bucketNo] = Math.max(bucketMax[bucketNo], i);
            }
        }

        int pre = 0, res = 0;

        for (int i = 0; i < bucketCount; i++) {

//            System.out.println(i + " " + bucketMax[i] + " " + bucketMin[i]);

            if (!bucketUsed[i])
                continue;
            res = Math.max(res,bucketMin[i] - bucketMax[pre]);
            pre = i;

//            System.out.println(res);
        }

        return res;

    }




}