package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UniqueBinarySearchTreesTest {

    UniqueBinarySearchTrees s;

    @Before
    public void init() {
        s = new UniqueBinarySearchTrees();
    }


    @Test
    public void basicTest1() {
        int n = 3;
        int res = 5;

        Assert.assertEquals(res, s.numTrees(n));
    }

    @Test
    public void basicTest2() {
        int n = 1;
        int res = 1;

        Assert.assertEquals(res, s.numTrees(n));
    }

    @Test
    public void basicTest3() {
        int n = 2;
        int res = 2;

        Assert.assertEquals(res, s.numTrees(n));
    }
}
