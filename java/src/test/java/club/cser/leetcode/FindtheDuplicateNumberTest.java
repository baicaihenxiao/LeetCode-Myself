package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindtheDuplicateNumberTest {
    private FindtheDuplicateNumber s;

    @Before
    public void init() {
        s = new FindtheDuplicateNumber();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1,3,4,2,2};
        int res = 2;
        Assert.assertEquals(res, s.findDuplicate3(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {3,1,3,4,2};
        int res = 3;
        Assert.assertEquals(res, s.findDuplicate3(nums));
    }

}
