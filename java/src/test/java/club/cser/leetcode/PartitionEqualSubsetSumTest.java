package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartitionEqualSubsetSumTest {
    private PartitionEqualSubsetSum s;

    @Before
    public void init() {
        s = new PartitionEqualSubsetSum();
    }

    @Test
    public void basicTest1() {
        int[] param = {1,5,11,5};
        boolean res = true;
        Assert.assertEquals(res, s.canPartition(param));
    }

    @Test
    public void basicTest2() {
        int[] param = {1,2,3,5};
        boolean res = false;
        Assert.assertEquals(res, s.canPartition(param));
    }

    @Test
    public void basicTest3() {
        int[] param = {1,2,5};
        boolean res = false;
        Assert.assertEquals(res, s.canPartition(param));
    }
}
