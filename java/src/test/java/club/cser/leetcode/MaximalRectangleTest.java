package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximalRectangleTest {
    private MaximalRectangle s;

    @Before
    public void init() {
        s = new MaximalRectangle();
    }

    @Test
    public void basicTest1() {
        char[][] nums = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = 6;

        Assert.assertEquals(res, s.maximalRectangle(nums));
    }
}
