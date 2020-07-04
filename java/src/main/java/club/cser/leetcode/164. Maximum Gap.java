package club.cser.leetcode;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
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


    // 基数排序
    public int maximumGap2(int[] nums) {
        if (nums.length < 2) return 0;

        int max = IntStream.of(nums).max().getAsInt();

        // 基数
        final int radix = 10;
        // 位数
        final int digits = String.valueOf(max).length();

        int curMod = 1;

        int[] tmpNums = new int[nums.length];

        IntBinaryOperator getCurrentDigit = (num, mod) -> (num / mod) % radix; // 比 先 % 后 / 好，因为这个模数恒定为10。

        for (int i = 0; i < digits; i++) {

            int[] counts = new int[radix];

            for (int c: nums)
                ++ counts[getCurrentDigit.applyAsInt(c, curMod)];

            for (int j = 1; j < counts.length; ++ j) {
                counts[j] += counts[j - 1];
            }

            for (int j = nums.length - 1; j >= 0 ; -- j) {
                tmpNums[-- counts[getCurrentDigit.applyAsInt(nums[j], curMod)]] = nums[j];
            }
            System.arraycopy(tmpNums, 0, nums, 0, nums.length);
            curMod *= radix;
        }

        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }

        return res;
    }


}

class RadixSortForNegativeInteger {
    // 基数排序2 对负数有效
    public int sort(int[] nums) {
        if (nums.length < 2) return 0;

        int max = IntStream.of(nums).max().getAsInt();

        // 基数
        final int radix = 256;

        // 前三位
        for (int i = 0; i < 3; i++) {
            countingSort(nums, radix, i * 8, (num, mod) -> (num >>> mod) & 0XFF); // 右移用 >>>，否则会用符号位填充
        }
        // 第四位
        countingSort(nums, radix, 24, (num, mod) -> (num >>> mod) ^ 0X80); // 翻转最高位

        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }

        return res;
    }

    private void countingSort(int[] nums, int radix, int currentByte, IntBinaryOperator getCurrentDigit) {
        int[] counts = new int[radix];
        int[] tmpNums = new int[nums.length];

        for (int c: nums)
            ++ counts[getCurrentDigit.applyAsInt(c, currentByte)];

        for (int j = 1; j < counts.length; ++ j) {
            counts[j] += counts[j - 1];
        }

        for (int j = nums.length - 1; j >= 0 ; -- j) {
            tmpNums[-- counts[getCurrentDigit.applyAsInt(nums[j], currentByte)]] = nums[j];
        }
        System.arraycopy(tmpNums, 0, nums, 0, nums.length);

        System.out.println(Arrays.toString(nums));
    }
}