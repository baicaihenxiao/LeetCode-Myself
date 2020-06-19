package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThreeSumWithMultiplicityTest {
    ThreeSumWithMultiplicity t;

    @Before
    public void init() {
        t = new ThreeSumWithMultiplicity();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        int res = 20;
        Assert.assertEquals(res, t.threeSumMulti(nums, target));
    }

    @Test
    public void basicTest2() {
        int[] nums = {1,1,2,2,2,2};
        int target = 5;
        int res = 12;
        Assert.assertEquals(res, t.threeSumMulti(nums, target));
    }

    @Test
    public void basicTest3() {
        int[] nums = {0,2,0,0};
        int target = 2;
        int res = 3;
        Assert.assertEquals(res, t.threeSumMulti(nums, target));
    }

    @Test
    public void cornerTest1() {
        int[] nums = {0,0,0};
        int target = 1;
        int res = 0;
        Assert.assertEquals(res, t.threeSumMulti(nums, target));
    }

    @Test
    public void cornerTest2() {
        int[] nums = {0,0,0};
        int target = 0;
        int res = 1;
        Assert.assertEquals(res, t.threeSumMulti(nums, target));
    }

    @Test
    public void cornerTest3() {
        int[] nums = {0,0,0,0,0};
        int target = 0;
        int res = 10; // 排列组合都忘了  $C_5^3 = \frac{5!}{3! \times (5-3)!}$
        Assert.assertEquals(res, t.threeSumMulti(nums, target));
    }
}
