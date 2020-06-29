package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MissingNumberTest {
    MissingNumber m;

    @Before
    public void init() {
        m = new MissingNumber();
    }

    @Test
    public void basicTest1() {
        int[] nums = {3,0,1};
        int res = 2;
        Assert.assertEquals(res, m.missingNumber(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {3,0,1};
        int res = 2;
        Assert.assertEquals(res, m.missingNumber1(nums));


    }
}
