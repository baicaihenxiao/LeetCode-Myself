package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortAnArrayTest {

    SortAnArray s;

    @Before
    public void init() {
        s = new SortAnArray();
    }

    @Test
    public void basicTest1() {
        int[] nums = {5,2,3,1};
        int[] res = {1,2,3,5};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sortArray(nums)));
    }

    @Test
    public void basicTest2() {
        int[] nums = {5,1,1,2,0,0};
        int[] res = {0,0,1,1,2,5};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sortArray(nums)));
    }
    @Test
    public void basicTest3() {
        int[] nums = {-1,2,-8,-10};
        int[] res = {-10,-8,-1,2};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sortArray(nums)));
    }


    @Test
    public void cornerTest1() {
        int[] nums = {};
        int[] res = {};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sortArray(nums)));
    }

    @Test
    public void cornerTest2() {
        int[] nums = {4};
        int[] res = {4};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sortArray(nums)));
    }

}
