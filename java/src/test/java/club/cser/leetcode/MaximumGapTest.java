package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumGapTest {
    MaximumGap s;

    @Before
    public void init() {
        s = new MaximumGap();
    }

    @Test
    public void basicTest1() {
        int[] nums = {3,6,9,1};
        int res = 3;

        Assert.assertEquals(res, s.maximumGap2(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {10};
        int res = 0;

        Assert.assertEquals(res, s.maximumGap2(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {1,10000000};
        int res = 9999999;

        Assert.assertEquals(res, s.maximumGap2(nums));
    }

    @Test
    public void basicTest4() {
        int[] nums = {-1, -10000000, -34, -89, -3423423, Integer.MAX_VALUE, Integer.MIN_VALUE, 123, 323, 2147483646, -2147483646};
        int[] res = {-2147483648, -2147483646, -10000000, -3423423, -89, -34, -1, 123, 323, 2147483646, 2147483647};
        System.out.println(Arrays.toString(nums));
        new RadixSortForNegativeInteger().sort(nums);
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(res));
    }
}
