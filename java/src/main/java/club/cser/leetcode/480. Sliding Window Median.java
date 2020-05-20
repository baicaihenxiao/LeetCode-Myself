package club.cser.leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SlidingWindowMedian {


    public double[] medianSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k == 0)
            return null;

        List<Integer> kList = IntStream.of(nums).boxed().limit(k).sorted().collect(Collectors.toList());
        double[] res = new double[nums.length - k + 1];

        //不能(int1 + int2)/2，会越界
        Function<List<Integer>, Double> getMedian =
                l -> ((k & 1) == 0) ? l.get(k / 2) / 2.0 + l.get(k / 2 - 1)/ 2.0 :
                        (double)l.get(k / 2);

        res[0] = getMedian.apply(kList);

        for (int i = k; i < nums.length; ++ i) {
            int j = 0;
            while (j < k && kList.get(j) < nums[i])
                ++ j;
            kList.add(j, nums[i]);
            kList.remove(Integer.valueOf(nums[i - k]));
            res[i - k + 1] = getMedian.apply(kList);
        }

        return res;
    }

}