package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortColorsTest {

    SortColors s;

    @Before
    public void init() {
        s = new SortColors();
    }

    @Test
    public void basicTest1() {
        int[] nums = {2,0,2,1,1,0};
        int[] res = {0,0,1,1,2,2};
        s.sortColors(nums);
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {0};
        int[] res = {0};
        s.sortColors(nums);
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {2, 0, 1};
        int[] res = {0, 1, 2};
        s.sortColors(nums);
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(nums));
    }

}
