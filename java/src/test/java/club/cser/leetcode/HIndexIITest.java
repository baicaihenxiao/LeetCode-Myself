package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HIndexIITest {
    HIndexII s;

    @Before
    public void init() {
        s = new HIndexII();
    }

    @Test
    public void basicTest1() {
        int[] nums = {0,1,3,5,6};
        int res = 3;

        Assert.assertEquals(res, s.hIndex(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {0,1, 4, 4 ,5,6};
        int res = 4;

        Assert.assertEquals(res, s.hIndex(nums));
    }

}
