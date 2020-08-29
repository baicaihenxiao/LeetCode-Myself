package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximalSquareTest {

    private MaximalSquare s;

    @Before
    public void init() {
        s = new MaximalSquare();
    }

    @Test
    public void basicTest1() {
        char[][] nums = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = 4;

        Assert.assertEquals(res, s.maximalSquare(nums));
    }

    @Test
    public void basicTest2() {
        char[][] nums = {{'0'}};
        int res = 0;

        Assert.assertEquals(res, s.maximalSquare(nums));
    }
}
